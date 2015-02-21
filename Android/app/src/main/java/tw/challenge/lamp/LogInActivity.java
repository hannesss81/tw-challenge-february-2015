package tw.challenge.lamp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Arrays;

public class LogInActivity extends Activity {

    final List<String> usernames = Arrays.asList("Test", "TransferWise", "CrtScnnr");
    final List<String> passwords = Arrays.asList("qwerty", "qwerty", "qwerty");

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_activity);


        Button button = (Button) findViewById(R.id.loginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = ((EditText) findViewById(R.id.username)).getText().toString();
                String password = ((EditText) findViewById(R.id.password)).getText().toString();
                Context context = getApplicationContext();
                boolean userExists = usernames.indexOf(username) > -1;
                if(userExists && passwords.get(usernames.indexOf(username)).equals(password)) {
                    //successful login
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                } else {

                    Toast.makeText(context, "Invalid username or password", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}

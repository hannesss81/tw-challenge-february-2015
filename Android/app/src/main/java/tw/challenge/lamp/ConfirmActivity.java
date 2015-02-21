package tw.challenge.lamp;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

public class ConfirmActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.confirm_activity);
        Toast.makeText(this, "Confirmed!", Toast.LENGTH_LONG).show();

}}

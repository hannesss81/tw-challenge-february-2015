package tw.challenge.lamp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Hans on 21.02.2015.
 */
public class User {

    String userName;
    String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        String resp = "";
        for( int i = 0; i < password.length(); i++) {
            resp+="*";
        }
        return resp;
    }

    public String getRealPassword() {
        return password;
    }

    public boolean validatePassword() {
        String path = getClass().getClassLoader().getResource(".").getPath();
        System.out.println(path);
        try {
            BufferedReader br = new BufferedReader(new FileReader("/app/conf/users"));
            String line;
            while((line= br.readLine()) != null) {
                System.out.println(line.split(" ")[1]);
                if(userName.equals(line.split(" ")[0]) && password.equals(line.split(" ")[1])) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("IOEXception");
            return false;
        }
        return false;
    }


}

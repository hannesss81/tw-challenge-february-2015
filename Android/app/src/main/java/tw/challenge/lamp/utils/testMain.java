package tw.challenge.lamp.utils;

/**
 * Created by Hans on 21.02.2015.
 */
public class testMain {
    public static void main(String args[]) {
        System.out.println("HELLO");
        User user = new User("joonas", "punane");
        user.validatePassword();
        System.out.println(user.validatePassword());
        Cache cache = new Cache();
    }
}

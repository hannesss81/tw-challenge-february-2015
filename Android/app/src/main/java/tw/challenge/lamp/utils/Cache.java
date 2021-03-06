package tw.challenge.lamp.utils;

import java.util.ArrayList;

/**
 * Created by Hans on 21.02.2015.
 */
public class Cache {

    ArrayList<Product> products = new ArrayList<>();

    public Cache() {
        products = initializeCache();
    }

    public ArrayList<Product> initializeCache() {
        ArrayList<Product> resp = new ArrayList<>();
        resp.add(new Product("Piim", 0.59, "442141253626"));
        resp.add(new Product("Leib", 0.73, "443298717660"));
        resp.add(new Product("Röster", 22.24, "123456789012"));
        resp.add(new Product("Coca-Cola", 0.92, "5678901234567"));
        resp.add(new Product("Corny - kollane", 0.75, "4011800544515"));
        resp.add(new Product("Bonaqua", 1.14, "40822426"));
        resp.add(new Product("Logitech m325", 15.28, "5099206027176"));
        resp.add(new Product("Corny - pruun", 0.75, "4011800530518"));
        return resp;
    }
}

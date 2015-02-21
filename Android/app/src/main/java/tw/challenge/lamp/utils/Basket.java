package tw.challenge.lamp.utils;

import java.util.ArrayList;

/**
 * Created by Hans on 21.02.2015.
 */
public class Basket {

    ArrayList<Product> products = new ArrayList<>();
    public Basket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product p) {
        boolean found = false;
        for( Product product : products) {
            if(product.equals(p)) {
                found = true;
                product.count = product.count+1;
            }
        }
        if(!found) {
            products.add(p);
        }
    }

    public void removeProduct(Product p) {
        for(int i = 0; i< products.size(); i++) {
            Product product = products.get(i);
            if(product.equals(p)) {
                product.count = product.count -1;
                if(product.count <= 0) {
                    products.remove(i);
                }
            }
        }
    }

    public double basketTotalCost() {
        double resp = 0.0;
        for (Product product : products) {
            resp += product.count * product.price;
        }
        return resp;
    }
}

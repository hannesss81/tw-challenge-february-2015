package tw.challenge.lamp.utils;

/**
 * Created by Hans on 21.02.2015.
 */
public class Product {

    String name;
    double price;
    String barCode;
    int count = 1;

    public Product(String name, double price, String barCode, int count) {
        this(name, price, barCode);
        this.count = count;
    }

    public Product(String name, double price, String barCode) {
        this.name = name;
        this.price = price;
        this.barCode = barCode;
        this.count = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!barCode.equals(product.barCode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return barCode.hashCode();
    }
}

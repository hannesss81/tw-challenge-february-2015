package tw.challenge.lamp.utils;

/**
 * Created by Hans on 21.02.2015.
 */
public class CreditCard {

    String number;
    String expDate;
    String cvv;

    public CreditCard(String number, String expDate, String cvv) {
        this.number = number;
        this.expDate = expDate;
        this.cvv = cvv;
    }
}

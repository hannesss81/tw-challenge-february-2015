package tw.challenge.lamp;

import android.os.AsyncTask;
import android.util.Log;

import com.stripe.model.Charge;
import com.stripe.Stripe;

import java.util.HashMap;
import java.util.Map;

public class Payment extends AsyncTask<String, Void, Void> {
    @Override
    protected Void doInBackground(String... urls)  {
        try {
            Stripe.apiKey = "tGN0bIwXnHdwOa85VABjPdSn8nWY7G7I"; // stripe public
// test key

            final Map<String, Object> cardParams = new HashMap<String, Object>();
            cardParams.put("number", "4242424242424242");
            cardParams.put("exp_month", 12);
            cardParams.put("exp_year", 2015);
            cardParams.put("cvc", "123");
            cardParams.put("name", "J Bindings Cardholder");
            cardParams.put("address_line1", "140 2nd Street");
            cardParams.put("address_line2", "4th Floor");
            cardParams.put("address_city", "San Francisco");
            cardParams.put("address_zip", "94105");
            cardParams.put("address_state", "CA");
            cardParams.put("address_country", "USA");

            final Map<String, Object> chargeParams = new HashMap<String, Object>();
            chargeParams.put("amount", 100);
            chargeParams.put("currency", "usd");
            chargeParams.put("card", cardParams);

            final Charge charge = Charge.create(chargeParams);
            System.out.println(charge);
        } catch (Exception e){
            Log.e("Payment", "errorr", e);
        }
        return null;
    }



    protected void onPostExecute() {
    }
}

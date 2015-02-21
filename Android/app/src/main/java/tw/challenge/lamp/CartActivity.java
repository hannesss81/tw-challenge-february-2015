package tw.challenge.lamp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import tw.challenge.lamp.utils.Basket;
import tw.challenge.lamp.utils.Product;


public class CartActivity  extends Activity {

    Basket basket = new Basket();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cart_activity);


    }

    public void checkOut(View view) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                CartActivity.this);
        String sum = "Select card to pay " + basket.basketTotalCost();
        builderSingle.setTitle(sum);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                CartActivity.this,
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("**** **** **** 2412");
        arrayAdapter.add("**** **** **** 4123");
        arrayAdapter.add("**** **** **** 1337");
        builderSingle.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builderSingle.setNegativeButton("Pay",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Intent intent = new Intent(this, ConfirmActivity.class);
                        //startActivity(intent);
                        Context context = getApplicationContext();
                        Toast.makeText(context, "Confirmed!", Toast.LENGTH_LONG);
                    }
                });

        builderSingle.setAdapter(arrayAdapter,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);
                        AlertDialog.Builder builderInner = new AlertDialog.Builder(
                                CartActivity.this);
                        builderInner.setMessage(strName);
                        builderInner.setTitle("Your Selected Item is");
                        builderInner.setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(
                                            DialogInterface dialog,
                                            int which) {
                                        dialog.dismiss();
                                    }
                                });
                        builderInner.show();
                    }
                });
        builderSingle.show();
    }

    public void startScan(View view) {
        Intent intent = new Intent(this, ScanActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String itemBarCode = data.getStringExtra("SCAN_RESULT");
                    Product product = new Product("Lamp", 1337, "133413371337");

                    boolean validProduct = false;
                    switch (itemBarCode){
                        case "442141253626":
                            product = new Product("Piim", 0.59, "442141253626");
                            validProduct = true;
                            break;
                        case "443298717660":
                            product = new Product("Leib", 0.73, "443298717660");
                            validProduct = true;
                            break;
                    }
                    if (validProduct){
                        basket.addProduct(product);
                        Toast.makeText(this, product.getName() + " added to cart" , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Unknown barcode" , Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}

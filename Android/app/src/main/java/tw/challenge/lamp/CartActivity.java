package tw.challenge.lamp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import tw.challenge.lamp.utils.Basket;
import tw.challenge.lamp.utils.Product;


public class CartActivity  extends Activity {

    Basket basket = new Basket();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cart_activity);

        Toast.makeText(this,"Welcome to Prisma", Toast.LENGTH_SHORT);

    }

    public void checkOut(View view) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                CartActivity.this);
        String sum = "Select card to pay " + (double)Math.round(basket.basketTotalCost() * 100) / 100;
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
        builderSingle.setAdapter(arrayAdapter,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strName = arrayAdapter.getItem(which);
                        AlertDialog.Builder builderInner = new AlertDialog.Builder(
                                CartActivity.this);
                        builderInner.setMessage(strName);
                        builderInner.setTitle("Confirm payment of " + (double)Math.round(basket.basketTotalCost() * 100) / 100);
                        builderInner.setPositiveButton("Confirm",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(
                                            DialogInterface dialog,
                                            int which) {
                                        Payment pay = new Payment();
                                        pay.execute();
                                        Intent confirmQR = new Intent(getApplicationContext(), ConfirmActivity.class);
                                        startActivity(confirmQR);
                                       ;
                                    }
                                });
                        builderInner.setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(
                                            DialogInterface dialog,
                                            int which) {
dialog.dismiss();
                                        ;
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
                    Log.i("MEIE", itemBarCode);
                    Product product = new Product("Lamp", 1337, "133413371337");

                    boolean validProduct = false;
                    switch (itemBarCode){
                        case "4421412536264":
                            product = new Product("Piim", 0.59, "442141253626");
                            validProduct = true;
                            break;
                        case "4432987176601":
                            product = new Product("Leib", 0.73, "443298717660");
                            validProduct = true;
                            break;
                        case "123456789012":
                            product = new Product("Röster", 22.24, "123456789012");
                            validProduct = true;
                            break;
                        case "5678901234567":
                            product = new Product("Coca-Cola", 0.92, "5678901234567");
                            validProduct = true;
                            break;
                        case "4011800544515":
                            product = new Product("Corny - kollane", 0.75, "4011800544515");
                            validProduct = true;
                            break;
                        case "4011800530518":
                            product = new Product("Corny - pruun", 0.75, "4011800530518");
                            validProduct = true;
                            break;
                        case "40822426":
                            product = new Product("Bonaqua", 1.14, "40822426");
                            validProduct = true;
                            break;
                        case "5099206027176":
                            product = new Product("Logitech m325", 15.28, "5099206027176");
                            validProduct = true;
                            break;
                    }
                    if (validProduct){
                        basket.addProduct(product);
                        ItemAdapter adapter = new ItemAdapter(this, basket.getProducts());
                        ListView listView = (ListView) findViewById(R.id.listView);
                        listView.setAdapter(adapter);

                        Toast.makeText(this, product.getName() + " added to cart" , Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Unknown barcode" , Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}

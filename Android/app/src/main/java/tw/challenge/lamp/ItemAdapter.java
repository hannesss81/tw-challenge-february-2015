package tw.challenge.lamp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tw.challenge.lamp.utils.Product;

/**
 * Created by Joonas on 21.02.2015.
 */
public class ItemAdapter extends ArrayAdapter<Product> {
    public ItemAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Product product = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.itemslist, parent, false);
        }
        // Lookup view for data population
        TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
        TextView itemPrice = (TextView) convertView.findViewById(R.id.price);
        // Populate the data into the template view using the data object
        itemName.setText(product.getName());
        itemPrice.setText(String.valueOf(product.getPrice()));
        // Return the completed view to render on screen
        return convertView;
    }
}

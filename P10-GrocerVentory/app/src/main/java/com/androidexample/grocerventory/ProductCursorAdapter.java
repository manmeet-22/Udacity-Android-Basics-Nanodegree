package com.androidexample.grocerventory;
/**
 * Created by Mani on 08-03-2017.
 */

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidexample.grocerventory.ProductContract.ProductEntry;

public class ProductCursorAdapter extends CursorAdapter {

    
    public ProductCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // Inflate a list item view using the layout specified in list_item.xml
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        Log.v("ProductCursorAdapter","BindView called");
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.item_product);
        TextView quantityTextView = (TextView) view.findViewById(R.id.item_quantity);
        TextView priceTextView = (TextView) view.findViewById(R.id.item_price);
        TextView sale = (TextView) view.findViewById(R.id.sale);
        ImageView productImageView = (ImageView) view.findViewById(R.id.list_image);


        // Find the columns of product attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_NAME);
        int quantityColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_QUANTITY);
        int priceColumnIndex = cursor.getColumnIndex(ProductEntry.COLUMN_PRODUCT_PRICE);
        int idColumnIndex = cursor.getColumnIndex(ProductEntry._ID);
       // int imageColumnIndex = cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_PRODUCT_IMAGE);

        // Read the product attributes from the Cursor for the current product
        String productName = cursor.getString(nameColumnIndex);
        final String productQuantity = cursor.getString(quantityColumnIndex);
        String productPrice = cursor.getString(priceColumnIndex);
        final String productId = cursor.getString(idColumnIndex);
        String productImageUri = cursor.getString(cursor.getColumnIndexOrThrow(ProductEntry.COLUMN_PRODUCT_IMAGE));

        if (productImageUri.startsWith("content://com.android.providers.media.documents/document/image")) {
            productImageView.setImageURI(Uri.parse(productImageUri));
        }
        else {
            productImageView.setImageResource(R.drawable.demo_image);
        }

        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ProductCurdorAdapter","Sale button Clicked");
                int quantity = Integer.parseInt(productQuantity);
                if (quantity <= 0) {
                    Toast.makeText(context, R.string.not_in_stock, Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    ContentValues values = new ContentValues();
                    values.put(ProductEntry.COLUMN_PRODUCT_QUANTITY, quantity);
                    Uri currentUri = ContentUris.withAppendedId(ProductEntry.CONTENT_URI, Long.parseLong(productId));
                    context.getContentResolver().update(currentUri, values, null, null);
                }
            }
        });
        // Update the TextViews with the attributes for the current product
        nameTextView.setText(productName);
        quantityTextView.setText(productQuantity);
        priceTextView.setText(productPrice);
    }
}

package com.androidexample.grocerventory;
/**
 * Created by Mani on 08-03-2017.
 */

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/*API Contract for the Pets app.*/
public final class ProductContract {

    private ProductContract() {}

    public static final String CONTENT_AUTHORITY = "com.androidexample.grocerventory";

    /*Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact the content provider.*/
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_PRODUCTS = "products";

    public static final class ProductEntry implements BaseColumns {

        /*The content URI to access the pet data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        /* The MIME type of the {@link #CONTENT_URI} for a list of products.*/
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        /*The MIME type of the {@link #CONTENT_URI} for a single pet.*/
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;

        /*Name of database table for products */
        public final static String TABLE_NAME = "products";

       /*Table items*/
        public final static String _ID = BaseColumns._ID;

        public final static String COLUMN_PRODUCT_NAME ="name";

        public final static String COLUMN_PRODUCT_QUANTITY = "quantity";

        public final static String COLUMN_PRODUCT_PRICE = "price";

        public final static String COLUMN_PRODUCT_DEALER = "dealer";

        public final static String COLUMN_PRODUCT_EMAIL = "email";

        public final static String COLUMN_PRODUCT_IMAGE = "image";

        public final static String COLUMN_PRODUCT_IMAGE_PATH = "image_path";

    }

}


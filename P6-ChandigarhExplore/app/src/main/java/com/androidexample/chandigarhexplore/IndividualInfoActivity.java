package com.androidexample.chandigarhexplore;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IndividualInfoActivity extends AppCompatActivity {


    public double lati;
    public double lon;

    public void getGeo(double a, double b) {
        lati = a;
        lon = b;
    }

    public double getLat() {
        return lati;
    }

    public double getLon() {
        return lon;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_info_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_individual);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get Name, Description, Image views
        TextView loc = (TextView) findViewById(R.id.title);
        TextView add1 = (TextView) findViewById(R.id.sco);
        TextView add2 = (TextView) findViewById(R.id.sector);
        ImageView img = (ImageView) findViewById(R.id.fullImage);

        // Get data passed in from Fragment
        Bundle details = getIntent().getExtras();
        // Location Details
        getGeo(details.getDouble("locationLon", getLon()), details.getDouble("locationLat", getLat()));

        loc.setText(details.getInt("location"));
        add1.setText(details.getInt("locationAdd1"));
        add2.setText(details.getInt("locationAdd2"));
        final int id = details.getInt("locationImage", -1);
        img.setImageResource(id);
    }

    public void openGoogleMap(View view) {
        //        use the lat and lon value to parse
        double lat = getLat();
        double lon = getLon();
        Uri location = Uri.parse("geo:" + lon + "," + lat);
        Log.v("hello", location.toString());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        mapIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        startActivity(mapIntent);
    }
}

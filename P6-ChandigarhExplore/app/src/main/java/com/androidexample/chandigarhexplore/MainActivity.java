package com.androidexample.chandigarhexplore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button explore = (Button) findViewById(R.id.explore);
        Button map = (Button) findViewById(R.id.map);

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent defaultIntent = new Intent(MainActivity.this, DefaultActivity.class);
                startActivity(defaultIntent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri chandigarh_map = Uri.parse("geo:30.741482, 76.768066");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, chandigarh_map);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }
}

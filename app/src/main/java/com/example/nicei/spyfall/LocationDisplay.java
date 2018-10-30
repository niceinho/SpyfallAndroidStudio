package com.example.nicei.spyfall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LocationDisplay extends AppCompatActivity {

    private TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_display);
        location = findViewById(R.id.locationList);
    }

    public void abort(View v) {
        finish();
    }
}

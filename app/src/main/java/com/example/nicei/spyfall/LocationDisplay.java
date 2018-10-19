package com.example.nicei.spyfall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LocationDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_display);
    }

    public void abort(View v) {
        finish();
    }
}

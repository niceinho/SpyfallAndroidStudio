package com.example.nicei.spyfall;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.*;

public class LocationDisplay extends AppCompatActivity {

    private TextView location, timer;
    private List<String> locationList;
    private String locationString;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_display);
        location = findViewById(R.id.locationList);
        locationList = Arrays.asList(getResources().getStringArray(R.array.locations));
        locationString = "";
        for (String s : locationList) {
            locationString = locationString + "\n" + s;
        }
        location.setText(locationString);

        timer = findViewById(R.id.timer);
        time = 0;

    }

    public void timer(View v) {
        time = 240;
        new CountDownTimer(30010,1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + checkDigit(time));
                time--;
            }
            public void onFinish() {
                alarm();
            }
        }.start();
    }
    public String checkDigit(int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void alarm() {
        new MediaPlayer().create(this, R.raw.ring).start();
    }
    public void abort(View v) {
        finish();
    }
}

package com.example.nicei.spyfall;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.*;

public class LocationDisplay extends AppCompatActivity {

    private TextView location, location2, timer;
    private String[] locationList, locationList2;
    private String locationString, locationString2;
    private int time;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_display);
        location = findViewById(R.id.locationList);
        location2 = findViewById(R.id.locationList2);
        locationList = getResources().getStringArray(R.array.locations);
        locationList2 = Arrays.copyOfRange(locationList,locationList.length/2+1,locationList.length-1);
        locationList = Arrays.copyOfRange(locationList,0,locationList.length/2+1);
        locationString = "";
        locationString2 = "";
        for (String s : locationList) {
            locationString = locationString + "\n" + s;
        }
        for (String s : locationList2) {
            locationString2 = locationString2 + "\n" + s;
        }
        location.setText(locationString);
        location2.setText(locationString2);
        timer = findViewById(R.id.timer);
        time = 0;
        timerRunning = false;
    }

    public void timer(View v) {
        if (timerRunning == true) return;
        timerRunning = true;
        time = 240;
        new CountDownTimer(242010,1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + checkDigit(time));
                time--;
            }
            public void onFinish() {
                alarm();
            }
        }.start();
    }
    public String checkDigit(int number) { //number is a int of seconds left in timer
        if (number >= 60) {
            if (number%60 <= 9) {
                return "0:0" + number;
            }
            return "" + number/60 + ":" + number%60;
        }
        return number <= 9 ? "0" + number : String.valueOf(number);
    }
    public void alarm() {
        new MediaPlayer().create(this, R.raw.ring).start();
    }
    public void abort(View v) {
        finish();
    }
}

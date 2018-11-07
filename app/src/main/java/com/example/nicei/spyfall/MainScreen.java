package com.example.nicei.spyfall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainScreen extends AppCompatActivity {

    private Button playerButtonMore, playerButtonLess, spyButtonMore, spyButtonLess;
    private TextView playerAmount, spyAmount;
    private Intent players, locations;
    private int player, spy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        player = 3; spy = 1;
        initiateViews();
        initiateIntents();
    }

    private void initiateViews() {
        playerButtonMore = findViewById(R.id.playerMore);
        playerButtonLess = findViewById(R.id.playerLess);
        spyButtonMore = findViewById(R.id.spyMore);
        spyButtonLess = findViewById(R.id.spyLess);
        playerAmount = findViewById(R.id.playerDisplay);
        spyAmount = findViewById(R.id.spyDisplay);
        spyAmount.setText(spy + " Spy");
        playerAmount.setText(player + " Players");
    }
    private void initiateIntents() {
        players = new Intent(this, PlayerDistribution.class);
        locations = new Intent(this, LocationDisplay.class);
    }

    public void startPlayer(View v) {
        players.putExtra("players", player);
        players.putExtra("spies", spy);
        startActivity(locations);
        startActivity(players);
    }

    public void updateScreen() {
        if (spy == 1) {
            spyAmount.setText(spy + " Spy");
        }
        else {
            spyAmount.setText(spy + " Spies");
        }
        playerAmount.setText(player + " Players");
    }

    public void morePlayer(View v) {
        if (player >= 12) {
            return;
        }
        player += 1;
        updateScreen();
    }
    public void lessPlayer(View v) {
        if (player <= 3) {
            return;
        }
        if (player <= spy) {
            return;
        }
        player -= 1;
        updateScreen();
    }
    public void moreSpy(View v) {
        if (spy >= player) {
            return;
        }
        spy += 1;
        updateScreen();
    }
    public void lessSpy(View v) {
        if (spy <= 1) {
            return;
        }
        spy -= 1;
        updateScreen();
    }
}

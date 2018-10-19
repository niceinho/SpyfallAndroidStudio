package com.example.nicei.spyfall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerDistribution extends AppCompatActivity {

    TextView role, currentPlayer, prompt, countDown;
    Button button;
    ImageView envelope;
    int player, spy, currentPlayerNum, currentAssignedSpyCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_distribution);

        player = getIntent().getIntExtra("player", 3);
        spy = getIntent().getIntExtra("spy", 1);

        role = findViewById(R.id.role);
        prompt = findViewById(R.id.prompt);
        button = findViewById(R.id.doneButton);
        countDown = findViewById(R.id.countdown);
        currentPlayer = findViewById(R.id.playerNumber);
        envelope = findViewById(R.id.envelope);

        currentPlayerNum = 1;

        role.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        return true;
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        role.setX(event.getRawX()-500);
                        role.setY(event.getRawY()-550);
                        return true;
                }
                return false;
            }
        });
    }

    public void nextRole() {
        if (currentPlayerNum >= player) {
            //change to last role
            showRole();
        }
        hideRole();
    }

    public void hideRole() {
        button.setVisibility(View.GONE);
        role.setVisibility(View.INVISIBLE);
        currentPlayer.setVisibility(View.INVISIBLE);
        envelope.setVisibility(View.INVISIBLE);

        prompt.setVisibility(View.VISIBLE);
        countDown.setVisibility(View.VISIBLE);
    }
    public void showRole() {
        button.setVisibility(View.VISIBLE);
        role.setVisibility(View.VISIBLE);
        currentPlayer.setVisibility(View.VISIBLE);
        envelope.setVisibility(View.VISIBLE);

        prompt.setVisibility(View.INVISIBLE);
        countDown.setVisibility(View.INVISIBLE);
    }
    public void updateScreen() {
        currentPlayer.setText(currentPlayerNum);
    }

    public void abort(View v) {
        finish();

    }
}

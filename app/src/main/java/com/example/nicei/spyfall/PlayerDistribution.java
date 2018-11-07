package com.example.nicei.spyfall;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

public class PlayerDistribution extends AppCompatActivity {

    private TextView role, currentPlayer, prompt, countDown, debug;
    private Button button;
    private ImageView envelope;
    private int player, spy, currentPlayerNum;
    private String[] locations;
    private String location;
    private ArrayList<String> rolesList;
    private int time;
    private float roleX, roleY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_distribution);

        player = getIntent().getIntExtra("players", 3);
        spy = getIntent().getIntExtra("spies", 1);

        role = findViewById(R.id.role);
        prompt = findViewById(R.id.nextplayerprompt);
        button = findViewById(R.id.doneButton);
        countDown = findViewById(R.id.countdown);
        currentPlayer = findViewById(R.id.playerNumber);
        envelope = findViewById(R.id.envelope);
        debug = findViewById(R.id.debug);

        randomizeRoles();
        currentPlayerNum = 1;
        currentPlayer.setText("Player "+currentPlayerNum);
        roleX = 87;
        roleY = 805;

        assignRole();

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
                        debug.setText("" + (((int)(event.getRawX()*179/234+23)*31)-((int)event.getRawY())));
                        return true;
                }
                return false;
            }
        });
    }

    public void nextRole(View v) {
        currentPlayerNum++;
        if (currentPlayerNum > player) {
            finish();
            return;
        }
        currentPlayer.setText("Player "+currentPlayerNum);
        hideRole();
        countDown();
        assignRole();
    }

    public void assignRole() {
        String roleString = rolesList.get(rolesList.size()-1);
        if (roleString.equals("You are the SPY!")) {
            role.setText("You are the SPY!");
        }
        else {
            role.setText("Location: " + location + "\nRole: " + rolesList.get(rolesList.size() - 1));
        }
        rolesList.remove(rolesList.size()-1);
    }
    public void hideRole() {
        button.setVisibility(View.INVISIBLE);
        role.setVisibility(View.INVISIBLE);
        currentPlayer.setVisibility(View.INVISIBLE);
        envelope.setVisibility(View.INVISIBLE);

        prompt.setVisibility(View.VISIBLE);
        countDown.setVisibility(View.VISIBLE);
    }

    public void countDown() {
        time = 3;
        new CountDownTimer(4010,1000) {
            public void onTick(long millisUntilFinished) {
                countDown.setText("" + time);
                time--;
            }
            public void onFinish() {
                showRole();
            }
        }.start();
    }

    public void showRole() {
        button.setVisibility(View.VISIBLE);
        role.setVisibility(View.VISIBLE);
        currentPlayer.setVisibility(View.VISIBLE);
        envelope.setVisibility(View.VISIBLE);
        role.setX(roleX);
        role.setY(roleY);

        prompt.setVisibility(View.INVISIBLE);
        countDown.setVisibility(View.INVISIBLE);
    }


    public void randomizeRoles() {
        locations = getResources().getStringArray(R.array.locations);
        location = locations[new Random().nextInt(locations.length)];
        int arrayID = this.getResources().getIdentifier(location.toLowerCase().replaceAll(" ","") , "array",this.getPackageName());
        String[] rolesArray = getResources().getStringArray(arrayID);
        rolesList = new ArrayList<String>(Arrays.asList(rolesArray));
        Collections.shuffle(rolesList);
        while (rolesList.size() > player - spy) {
            rolesList.remove(rolesList.size()-1);
        }
        while (spy > 0) {
            rolesList.add("You are the SPY!");
            spy--;
        }
        Collections.shuffle(rolesList);
    }
}

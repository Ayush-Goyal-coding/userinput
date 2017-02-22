package com.example.my.practiceset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    int totalA,totalB = 0;
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void add3forA(View v){
        totalA = totalA+2;
        displayForTeamA(totalA);
    }

    public void add2forA(View v){
        totalA = totalA+2;
        displayForTeamA(totalA);
    }
    public void add1forA(View v){
        totalA = totalA+2;
        displayForTeamA(totalA);
    }
    public void add3forB(View v){
        totalB = totalB+2;
        displayForTeamA(totalB);
    }

    public void add2forB(View v){
        totalB = totalB+2;
        displayForTeamA(totalB);
    }
    public void add1forB(View v){
        totalB = totalB+2;
        displayForTeamA(totalB);
    }
    public void reset(View v){
        totalA = 0;
        totalB = 0;
        displayForTeamA(totalA);
        displayForTeamB(totalB);
    }
}

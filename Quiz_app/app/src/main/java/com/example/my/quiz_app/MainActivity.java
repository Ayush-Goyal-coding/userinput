package com.example.my.quiz_app;
// add questions,NameBox

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }


    public void submit(View view){
        int score =0 ;
        RadioButton A1 = (RadioButton) findViewById(R.id.Q1correct);
        RadioButton A2 = (RadioButton) findViewById(R.id.Q2correct);
        if (A1.isChecked())
            score++;
        if (A2.isChecked())
            score++;
        EditText name = (EditText)findViewById(R.id.name) ;
        String Name = name.getText().toString();
        display(score,Name);
    }
    private void display(int score,String name){

        TextView submitscore  = (TextView) findViewById(R.id.Ans);
        submitscore.setText(message(score,name));
    }
    private String message(int score,String name)
    {
       String displayMessage =  "Wow "+ name+ "! Your scored " + score;
        return displayMessage;
    }

}

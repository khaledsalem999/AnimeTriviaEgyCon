package com.example.khaled.animetriviaegycon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView DaRules = (TextView) findViewById(R.id.Rules);

        DaRules.setText(" 1. Pick 10 of your facorite animes to be asked 2 questions about each on of them" +
                "\n\n 2. You have 10 seconds to answer each question" +
                "\n\n 3. The questions are random and 2 people will not have the same list of questions");

        Button Startbutton = (Button) findViewById(R.id.button2);

        Startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RulesActivity.this,MainActivity.class));
                finish();
            }
        });


    }

}

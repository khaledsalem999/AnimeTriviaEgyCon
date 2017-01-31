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
        DaRules.setTextSize(20);
        DaRules.setText(" 1. Every person gets 2 chances for participation." +
                        "\n\n 2. You choose the 10 anime series that you want to be quizzed on." +
                "\n\n 3. You have 30 seconds to answer each question." +
                "\n\n 4. If you exit the application, your results are submitted.");

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

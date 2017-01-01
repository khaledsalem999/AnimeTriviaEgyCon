package com.example.khaled.animetriviaegycon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
ArrayList<Question> questionList;
int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        questionList = (ArrayList<Question>) getIntent().getSerializableExtra("Questions");

        for (int i=0; i<questionList.size();i++){
            if(questionList.get(i).getScore()==1){
                score+=1;
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.BackToAnimes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final TextView HSLable = (TextView) findViewById(R.id.HighScoreLableResults);
        final TextView rightanslables = (TextView) findViewById(R.id.rightanslableResults);
        final TextView leaderboardlables = (TextView) findViewById(R.id.leaderboardlableResults);
        final TextView personalscores = (TextView) findViewById(R.id.personalscoreResults);
        final TextView rans = (TextView) findViewById(R.id.rightansResults);
        final TextView rank = (TextView) findViewById(R.id.worldplaceResults);
        rans.setText(Integer.toString(score));

        //Animation Declaration
        Animation animation1 = AnimationUtils.loadAnimation(ResultsActivity.this,android.R.anim.slide_in_left);
        Animation animation3 = AnimationUtils.loadAnimation(ResultsActivity.this,android.R.anim.slide_in_left);
        Animation animation4 = AnimationUtils.loadAnimation(ResultsActivity.this,android.R.anim.slide_in_left);
        Animation animation5 = AnimationUtils.loadAnimation(ResultsActivity.this,android.R.anim.fade_in);
        Animation animation7 = AnimationUtils.loadAnimation(ResultsActivity.this,android.R.anim.fade_in);
        Animation animation8 = AnimationUtils.loadAnimation(ResultsActivity.this,android.R.anim.fade_in);

        //Animation Duration
        animation1.setDuration(200);
        animation3.setDuration(200);
        animation4.setDuration(200);
        animation5.setDuration(200);
        animation7.setDuration(200);
        animation8.setDuration(200);

        //Animation when to start
        animation3.setStartOffset(200);
        animation4.setStartOffset(400);
        animation7.setStartOffset(200);
        animation8.setStartOffset(400);

        //Animation start
        HSLable.startAnimation(animation1);
        rightanslables.startAnimation(animation3);
        leaderboardlables.startAnimation(animation4);
        personalscores.startAnimation(animation5);
        rans.startAnimation(animation7);
        rank.startAnimation(animation8);

    }

}

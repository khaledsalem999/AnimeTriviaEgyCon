package com.example.khaled.animetriviaegycon;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {
    ArrayList<Question> questionList;
    int score=0;
    long Duration=0;
    FirebaseAuth auth= FirebaseAuth.getInstance();
    DatabaseReference ref= FirebaseDatabase.getInstance().getReference("results");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        questionList = (ArrayList<Question>) getIntent().getSerializableExtra("Questions");
        Duration = getIntent().getLongExtra("Time",0);

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
        HSLable.setText("Duration");
        personalscores.setText( Long.toString((Duration/60000)) +":"+ Long.toString(Duration/1000)+":" + Long.toString((Duration%1000)/10) );
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

        RatingBar rating = (RatingBar)findViewById(R.id.ratingBarResults);
        rating.setMax(20);
        rating.setProgress(score);

        writeResult();
    }

    public void writeResult(){
        final String userId = auth.getCurrentUser().getUid();
        ref = FirebaseDatabase.getInstance().getReference("users");
        ref.orderByChild("id").equalTo(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fname= dataSnapshot.child(userId).child("firstName").getValue().toString();
                String lname= dataSnapshot.child(userId).child("lastName").getValue().toString();;

                ResultForm result = new ResultForm(userId, fname, lname, score, 20-score, Duration);

                ref= FirebaseDatabase.getInstance().getReference("results");
                ref.push().setValue(result);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }

}

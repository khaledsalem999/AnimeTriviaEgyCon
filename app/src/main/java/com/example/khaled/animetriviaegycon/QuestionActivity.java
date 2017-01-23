package com.example.khaled.animetriviaegycon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("questions");
    FirebaseAuth auth= FirebaseAuth.getInstance();

    int counter;
    ArrayList<Question> questionList;
    private CountDownTimer Qtimer;
    long TimeInMills;
    long TimeInSec;
    long Duration;
    long TimeScore;
    long tillFinished;
    int score=0;
    int pauseCount=0;
    final Context context= this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        counter = getIntent().getIntExtra("Counter",0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Question number "+ (counter+1) );
        setSupportActionBar(toolbar);
        questionList = (ArrayList<Question>) getIntent().getSerializableExtra("Questions");
        Duration = getIntent().getLongExtra("Time",0);
        TimeScore = getIntent().getLongExtra("TimeScore",0);
        final Button contbutton = (Button) findViewById(R.id.cont);

        Log.e("Question", Integer.toString(counter));

        ImageView img = (ImageView) findViewById(R.id.imageView2);

        final TextView question = (TextView) findViewById(R.id.question);

        ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar13);
        progress.setMax(20);
        progress.setProgress(counter);

        Button buttons[] = new Button[3];

        buttons[0] = (Button) findViewById(R.id.ans1);
        buttons[1] = (Button) findViewById(R.id.ans2);
        buttons[2] = (Button) findViewById(R.id.ans3);

        String answer[]= new String[3];
        answer[0]=questionList.get(counter).getCorrectAns().substring(1);
        answer[1]=questionList.get(counter).getSecAns();
        answer[2]=questionList.get(counter).getThirdAns();

        question.setText(questionList.get(counter).getQuestion());

        int x = (int) (Math.random()*3);
        buttons[0].setText(answer[x]);
        x=(x+1)%3;
        buttons[2].setText(answer[x]);
        x=(x+1)%3;
        buttons[1].setText(answer[x]);

        buttons[0].setOnClickListener(this);
        buttons[1].setOnClickListener(this);
        buttons[2].setOnClickListener(this);

        //Timer shit
        final TextView TimerLable = (TextView) findViewById(R.id.Timer);
        Qtimer = new CountDownTimer(30 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TimerLable.setText("" + millisUntilFinished/1000);
                TimeInSec = millisUntilFinished/1000;
                TimeInMills= 30 * 1000 - millisUntilFinished;
                tillFinished=millisUntilFinished;
            }

            @Override
            public void onFinish() {
                contbutton.setVisibility(View.VISIBLE);
                if(counter<19){
                    counter++;
                    contbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Duration+=TimeInMills;
                            questionList.get(counter).setScore(0);
                            questionList.get(counter).setTimeScore(0);
                            Intent quiz = new Intent(QuestionActivity.this, QuestionActivity.class);
                            quiz.putExtra("Counter", counter);
                            quiz.putExtra("Questions",questionList);
                            quiz.putExtra("Time",Duration);
                            quiz.putExtra("TimeScore",TimeScore);
                            finish();
                            Qtimer.cancel();
                            QuestionActivity.this.startActivity(quiz);
                        }
                    });
                }
                else{
                    contbutton.setVisibility(View.VISIBLE);
                    contbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Duration+=TimeInMills;
                            questionList.get(counter).setScore(0);
                            questionList.get(counter).setTimeScore(0);
                            Intent result = new Intent(QuestionActivity.this, ResultsActivity.class);
                            result.putExtra("Questions",questionList);
                            result.putExtra("Time",Duration);
                            result.putExtra("TimeScore",TimeScore);
                            finish();
                            Qtimer.cancel();
                            QuestionActivity.this.startActivity(result);
                        }
                    });

                }
            }
        };

        PicassoClient.downloadImage(this,questionList.get(counter).getPicUrl(),img);
        Qtimer.start();

    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        Button contbutton = (Button) findViewById(R.id.cont);
        Button buttons[] = new Button[3];
        buttons[0] = (Button) findViewById(R.id.ans1);
        buttons[1] = (Button) findViewById(R.id.ans2);
        buttons[2] = (Button) findViewById(R.id.ans3);
        int id= b.getId();

        Qtimer.cancel();

        switch(id){
            case R.id.ans1:
            {
                if(questionList.get(counter).getCorrectAns().substring(1).equals(b.getText())){
                    questionList.get(counter).setScore(1);
                    TimeScore = TimeScore +(-1000000 - tillFinished);
                    contbutton.setVisibility(View.VISIBLE);
                    buttons[1].setVisibility(View.INVISIBLE);
                    buttons[1].setEnabled(false);
                    buttons[2].setVisibility(View.INVISIBLE);
                    buttons[2].setEnabled(false);
                    b.setBackgroundColor(Color.GREEN);
                }
                else{
                    questionList.get(counter).setScore(0);
                    questionList.get(counter).setTimeScore(0);
                    contbutton.setVisibility(View.VISIBLE);
                    buttons[1].setVisibility(View.INVISIBLE);
                    buttons[1].setEnabled(false);
                    buttons[2].setVisibility(View.INVISIBLE);
                    buttons[2].setEnabled(false);
                    b.setBackgroundColor(Color.RED);
                }
                break;
            }
            case R.id.ans2:
            {
                if(questionList.get(counter).getCorrectAns().substring(1).equals(b.getText())){
                    questionList.get(counter).setScore(1);
                    TimeScore = TimeScore +(-1000000 - tillFinished);
                    b.setBackgroundColor(Color.GREEN);
                    buttons[0].setVisibility(View.INVISIBLE);
                    buttons[0].setEnabled(false);
                    buttons[2].setVisibility(View.INVISIBLE);
                    buttons[2].setEnabled(false);
                    contbutton.setVisibility(View.VISIBLE);
                }
                else{
                    questionList.get(counter).setScore(0);
                    questionList.get(counter).setTimeScore(0);
                    buttons[0].setVisibility(View.INVISIBLE);
                    buttons[0].setEnabled(false);
                    buttons[2].setVisibility(View.INVISIBLE);
                    buttons[2].setEnabled(false);
                    b.setBackgroundColor(Color.RED);
                    contbutton.setVisibility(View.VISIBLE);
                }
                break;
            }
            case R.id.ans3:
            {
                if(questionList.get(counter).getCorrectAns().substring(1).equals(b.getText())){
                    questionList.get(counter).setScore(1);
                    TimeScore = TimeScore +(-1000000 - tillFinished);
                    b.setBackgroundColor(Color.GREEN);
                    buttons[0].setVisibility(View.INVISIBLE);
                    buttons[0].setEnabled(false);
                    buttons[1].setVisibility(View.INVISIBLE);
                    buttons[1].setEnabled(false);
                    contbutton.setVisibility(View.VISIBLE);
                }
                else{
                    questionList.get(counter).setScore(0);
                    questionList.get(counter).setTimeScore(0);
                    b.setBackgroundColor(Color.RED);
                    buttons[0].setVisibility(View.INVISIBLE);
                    buttons[0].setEnabled(false);
                    buttons[1].setVisibility(View.INVISIBLE);
                    buttons[1].setEnabled(false);
                    contbutton.setVisibility(View.VISIBLE);
                }
                break;
            }

        }

        if(counter<19){
            counter++;
            Qtimer.cancel();
            contbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Duration+=TimeInMills;
                    Intent quiz = new Intent(QuestionActivity.this, QuestionActivity.class);
                    quiz.putExtra("Counter", counter);
                    quiz.putExtra("Questions",questionList);
                    quiz.putExtra("Time",Duration);
                    quiz.putExtra("TimeScore",TimeScore);
                    Qtimer.cancel();
                    finish();
                    QuestionActivity.this.startActivity(quiz);
                }
            });
        }
        else{
            Qtimer.cancel();
            contbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Duration+=TimeInMills;
                    Intent result = new Intent(QuestionActivity.this, ResultsActivity.class);
                    result.putExtra("Questions",questionList);
                    result.putExtra("Time",Duration);
                    result.putExtra("TimeScore",TimeScore);
                    Qtimer.cancel();
                    finish();
                    QuestionActivity.this.startActivity(result);
                }
            });

        }
    }



    @Override
    public void onBackPressed() {
        Toast.makeText(QuestionActivity.this, "You can't go back.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause(){
        super.onPause();

    }

    @Override
    public void onResume() {
        super.onResume();
        if (pauseCount <1) {
            pauseCount++;
        }
        else if(pauseCount>=1) {
            Toast.makeText(QuestionActivity.this, "Your trial has been submitted. Please restart the application.", Toast.LENGTH_LONG).show();
            writeResult();
            this.finish();
        }
    }

    public void writeResult(){
        for (int i=0; i<questionList.size();i++){
            if(questionList.get(i).getScore()==1){
                score+=1;
            }
        }

        final String userId = auth.getCurrentUser().getUid();
        ref = FirebaseDatabase.getInstance().getReference("users");
        ref.orderByChild("id").equalTo(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String fname= dataSnapshot.child(userId).child("firstName").getValue().toString();
                String lname= dataSnapshot.child(userId).child("lastName").getValue().toString();;

                ResultForm result = new ResultForm(userId, fname, lname, score, 20-score, Duration,TimeScore);

                ref= FirebaseDatabase.getInstance().getReference("results");
                ref.push().setValue(result);
                triggerRebirth(context);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public static void triggerRebirth(Context context) {
        Intent intent = new Intent(context, RulesActivity.class);
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }

        Runtime.getRuntime().exit(0);
    }

}

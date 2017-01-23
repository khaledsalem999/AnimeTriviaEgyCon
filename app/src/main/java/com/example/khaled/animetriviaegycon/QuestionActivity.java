package com.example.khaled.animetriviaegycon;

import android.content.Intent;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("questions");
    int counter;
    ArrayList<Question> questionList;
    private CountDownTimer Qtimer;
    long TimeInMills;
    long TimeInSec;
    long Duration;
    long TimeScore;
    long tillFinished;

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
                if(counter<19){
                    Duration+=TimeInMills;
                    questionList.get(counter).setScore(0);
                    questionList.get(counter).setTimeScore(0);
                    counter++;
                    Intent quiz = new Intent(QuestionActivity.this, QuestionActivity.class);
                    quiz.putExtra("Counter", counter);
                    quiz.putExtra("Questions",questionList);
                    quiz.putExtra("Time",Duration);
                    quiz.putExtra("TimeScore",TimeScore);
                    finish();
                    Qtimer.cancel();
                    QuestionActivity.this.startActivity(quiz);
                }
                else{
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
            }
        };

        PicassoClient.downloadImage(this,questionList.get(counter).getPicUrl(),img);
        Qtimer.start();

    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;

        int id= b.getId();

        switch(id){
            case R.id.ans1:
            {
                if(questionList.get(counter).getCorrectAns().substring(1).equals(b.getText())){
                    questionList.get(counter).setScore(1);
                    TimeScore = TimeScore +(-1000000 - tillFinished);
                }
                else{
                    questionList.get(counter).setScore(0);
                    questionList.get(counter).setTimeScore(0);
                }
                break;
            }
            case R.id.ans2:
            {
                if(questionList.get(counter).getCorrectAns().substring(1).equals(b.getText())){
                    questionList.get(counter).setScore(1);
                    TimeScore = TimeScore +(-1000000 - tillFinished);
                }
                else{
                    questionList.get(counter).setScore(0);
                    questionList.get(counter).setTimeScore(0);
                }
                break;
            }
            case R.id.ans3:
            {
                if(questionList.get(counter).getCorrectAns().substring(1).equals(b.getText())){
                    questionList.get(counter).setScore(1);
                    TimeScore = TimeScore +(-1000000 - tillFinished);
                }
                else{
                    questionList.get(counter).setScore(0);
                    questionList.get(counter).setTimeScore(0);
                }
                break;
            }

        }

        if(counter<19){
            counter++;
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
        else{
                    Duration+=TimeInMills;
                    Intent result = new Intent(QuestionActivity.this, ResultsActivity.class);
                    result.putExtra("Questions",questionList);
                    result.putExtra("Time",Duration);
                    result.putExtra("TimeScore",TimeScore);
                    Qtimer.cancel();
                    finish();
                    QuestionActivity.this.startActivity(result);

        }
    }



    @Override
    public void onBackPressed() {
        Toast.makeText(QuestionActivity.this, "There is no going back :)",
                Toast.LENGTH_LONG).show();
    }

}

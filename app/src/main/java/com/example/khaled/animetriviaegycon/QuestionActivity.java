package com.example.khaled.animetriviaegycon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuestionActivity extends AppCompatActivity{
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("questions");
    int counter;
    ArrayList<Question> questionList;
    ArrayList<String> answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        questionList = (ArrayList<Question>) getIntent().getSerializableExtra("Questions");
        counter = getIntent().getIntExtra("Counter",0);
        Log.e("Question", Integer.toString(counter));

        final TextView question = (TextView) findViewById(R.id.question);
        final Button ans1 = (Button) findViewById(R.id.ans1);
        final Button ans2 = (Button) findViewById(R.id.ans2);
        final Button ans3 = (Button) findViewById(R.id.ans3);

        question.setText(questionList.get(counter).getQuestion());
        ans1.setText(questionList.get(counter).getCorrectAns());
        ans2.setText(questionList.get(counter).getSecAns());
        ans3.setText(questionList.get(counter).getThirdAns());

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter<19){
                    counter++;
                    Intent quiz = new Intent(QuestionActivity.this, QuestionActivity.class);
                    quiz.putExtra("Counter", counter);
                    quiz.putExtra("Questions",questionList);
                    QuestionActivity.this.startActivity(quiz);
                }
                else{
                    Intent result = new Intent(QuestionActivity.this, ResultsActivity.class);
                    QuestionActivity.this.startActivity(result);
                }
            }
        });
        //ans2.setOnClickListener();
        //ans3.setOnClickListener();
    }
}

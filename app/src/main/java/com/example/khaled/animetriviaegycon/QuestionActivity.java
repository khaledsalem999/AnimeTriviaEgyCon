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
    ArrayList<Question> questions;
    ArrayList<Anime> anime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        counter = getIntent().getIntExtra("Counter",0);
        Log.e("Question", Integer.toString(counter));
        anime= (ArrayList<Anime>) getIntent().getSerializableExtra("AnimeList");
        Log.e("Your anime:", anime.get(counter).getname());

            final TextView question = (TextView) findViewById(R.id.question);
            final Button ans1 = (Button) findViewById(R.id.ans1);
            final Button ans2 = (Button) findViewById(R.id.ans2);
            final Button ans3 = (Button) findViewById(R.id.ans3);

            ref.orderByChild("0").equalTo(anime.get(counter).getname()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    question.setText(dataSnapshot.getChildren().iterator().next().child("2").getValue().toString());
                    ans1.setText(dataSnapshot.getChildren().iterator().next().child("3").getValue().toString());
                    ans2.setText(dataSnapshot.getChildren().iterator().next().child("4").getValue().toString());
                    ans3.setText(dataSnapshot.getChildren().iterator().next().child("5").getValue().toString());
                    ans1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(counter<19){
                                counter++;
                                Intent quiz = new Intent(QuestionActivity.this, QuestionActivity.class);
                                quiz.putExtra("AnimeList",anime);
                                quiz.putExtra("Counter", counter);
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

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
    }
}

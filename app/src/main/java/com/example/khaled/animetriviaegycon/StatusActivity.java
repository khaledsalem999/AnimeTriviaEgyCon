package com.example.khaled.animetriviaegycon;

import android.media.Rating;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class StatusActivity extends Fragment {

    public StatusActivity() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final long[] best = {0};
        final long[] bestDuration = {100000000};
        final int[] total = {0};
        final int[] index = {1};
        final ArrayList<String> idList = new ArrayList<String>();

        final View view = inflater.inflate(R.layout.content_status, container, false);

        final TextView HSLable = (TextView) view.findViewById(R.id.HighScoreLable);
        HSLable.setVisibility(View.INVISIBLE);
        HSLable.setText("Best score");
        final TextView Fanimes = (TextView) view.findViewById(R.id.favanime);
        Fanimes.setVisibility(View.INVISIBLE);
        Fanimes.setText("Best duration");
        final TextView rightanslables = (TextView) view.findViewById(R.id.rightanslable);
        rightanslables.setVisibility(View.INVISIBLE);
        rightanslables.setText("Correct answers");
        final TextView leaderboardlables = (TextView) view.findViewById(R.id.leaderboardlable);
        leaderboardlables.setVisibility(View.INVISIBLE);
        leaderboardlables.setText("Rank");

        final TextView personalscores = (TextView) view.findViewById(R.id.personalscore);
        personalscores.setVisibility(View.INVISIBLE);
        final TextView fanimu = (TextView) view.findViewById(R.id.favanimename);
        fanimu.setVisibility(View.INVISIBLE);
        final TextView rans = (TextView) view.findViewById(R.id.rightans);
        rans.setVisibility(View.INVISIBLE);
        final TextView rank = (TextView) view.findViewById(R.id.worldplace);
        rank.setVisibility(View.INVISIBLE);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("results");
        final DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("results");

        final FirebaseAuth auth = FirebaseAuth.getInstance();

        ref.orderByChild("userID").equalTo(auth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int count = (int) dataSnapshot.getChildrenCount();
                final long max = count*20;

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    if( best[0] < postSnapshot.child("correctAnswers").getValue(Long.class)){
                        best[0] = postSnapshot.child("correctAnswers").getValue(Long.class);
                    }
                    if(bestDuration[0] > postSnapshot.child("timeInMillis").getValue(Long.class)){
                        bestDuration[0] = postSnapshot.child("timeInMillis").getValue(Long.class);
                    }

                    total[0] += postSnapshot.child("correctAnswers").getValue(Integer.class);
                }

                ref2.orderByChild("timeScore").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                            if(postSnapshot.child("userID").getValue(String.class).equals(auth.getCurrentUser().getUid())){
                                break;
                            }
                            else if (postSnapshot.child("userID").getValue(String.class).equals(auth.getCurrentUser().getUid()) != true
                                     && idList.contains(postSnapshot.child("userID").getValue(String.class))!=true) {
                                idList.add(postSnapshot.child("userID").getValue(String.class));
                                index[0]++;
                                Log.d("rank",Integer.toString(index[0]));
                            }
                        }

                        personalscores.setText(Long.toString(best[0]));

                        rans.setText(Integer.toString(total[0]));

                        fanimu.setText(String.format("%02d:%02d:%02d",
                                TimeUnit.MILLISECONDS.toHours(bestDuration[0]),
                                TimeUnit.MILLISECONDS.toMinutes(bestDuration[0]) -
                                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(bestDuration[0])),
                                TimeUnit.MILLISECONDS.toSeconds(bestDuration[0]) -
                                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(bestDuration[0]))));

                        RatingBar rate = (RatingBar) view.findViewById(R.id.ratingBar);
                        rate.setMax((int)max);
                        rate.setProgress((int)total[0]);
                        rank.setText(Integer.toString(index[0]));


                        HSLable.setVisibility(View.VISIBLE);
                        Fanimes.setVisibility(View.VISIBLE);
                        rightanslables.setVisibility(View.VISIBLE);
                        leaderboardlables.setVisibility(View.VISIBLE);
                        personalscores.setVisibility(View.VISIBLE);
                        fanimu.setVisibility(View.VISIBLE);
                        rans.setVisibility(View.VISIBLE);
                        rank.setVisibility(View.VISIBLE);

                        setHasOptionsMenu(true);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        return;
    }

}

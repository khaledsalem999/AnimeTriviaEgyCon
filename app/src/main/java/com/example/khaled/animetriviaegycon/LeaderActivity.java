package com.example.khaled.animetriviaegycon;

import android.graphics.Color;
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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeaderActivity extends Fragment {
    ListView lstItems;
    ArrayAdapter<String> allItemsAdapter;
    ArrayList<String> ids;

    public LeaderActivity() {
        // Required empty public constructor
    }

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_leader, container, false);
        lstItems = (ListView)view.findViewById(R.id.lista);
        ids=new ArrayList<String>();
        setHasOptionsMenu(true);
        final ArrayList<String> prueba = new ArrayList<String>();
        allItemsAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), R.layout.content_leader_text, prueba);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("results");
        Query query = ref.orderByChild("timeScore");
        final DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference("users");
        final int[] index = {0};

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Inflate the layout for this fragment
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    final String id = postSnapshot.child("userID").getValue().toString();
                    final String score = "    " + postSnapshot.child("correctAnswers").getValue().toString();
                    final String time = postSnapshot.child("timeInMillis").getValue().toString();
                    final long duration = Long.parseLong(time);

                    Log.d("id",id);
                    if (ids.contains(id) != true && id!=null) {
                        ref2.orderByKey().equalTo(id).limitToFirst(1).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String fname = dataSnapshot.getChildren().iterator().next().child("firstName").getValue().toString();
                                String lname = dataSnapshot.getChildren().iterator().next().child("lastName").getValue().toString();
                                String email = dataSnapshot.getChildren().iterator().next().child("email").getValue().toString();
                                String phone = dataSnapshot.getChildren().iterator().next().child("phoneNumber").getValue().toString();

                                long Duration =duration;

                                prueba.add((index[0] + 1) + "    " + fname + " " + lname + score + "     " + String.format("%02d:%02d",
                                        TimeUnit.MILLISECONDS.toMinutes(Duration) -
                                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(Duration)),
                                        TimeUnit.MILLISECONDS.toSeconds(Duration) -
                                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(Duration)))
                                        + "\n" + "Email: " + email + "\n" + "Phone: " + phone
                                );
                                index[0]++;
                                lstItems.setAdapter(allItemsAdapter);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        //view.invalidate();
                    }
                    ids.add(id);
                }
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
        inflater.inflate(R.menu.main, menu);
        return;
    }
}


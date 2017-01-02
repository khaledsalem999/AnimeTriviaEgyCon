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

public class LeaderActivity extends Fragment {
    ListView lstItems;
    ArrayAdapter<String> allItemsAdapter;

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
        setHasOptionsMenu(true);
        final ArrayList<String> prueba = new ArrayList<String>();
        allItemsAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1,prueba);

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference("results");
        Query query = ref.orderByChild("wrongAnswers");

        query.limitToFirst(20).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Inflate the layout for this fragment
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String name = postSnapshot.child("firstName").getValue().toString()
                            + " "+postSnapshot.child("lastName").getValue().toString();
                    String score = "    "+ postSnapshot.child("correctAnswers").getValue().toString();
                    String time = "     "+ postSnapshot.child("timeInMillis").getValue().toString();
                    prueba.add(name + score + time);
                    Log.e("Get Data", name);
                    lstItems.setAdapter(allItemsAdapter);
                    view.invalidate();
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


package com.example.khaled.animetriviaegycon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeaderActivity extends Fragment {

    public LeaderActivity() {
        // Required empty public constructor
    }

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_leader, container, false);
        // Inflate the layout for this fragment

        ListView lstItems = (ListView)view.findViewById(R.id.lista);

        ArrayList<String> prueba = new ArrayList<String>();

        for(int i = 0 ; i<20 ; i++){
            prueba.add("player "+ i);
        }

        ArrayAdapter<String> allItemsAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1,prueba);

        lstItems.setAdapter(allItemsAdapter);




        return view;
    }

}


package com.example.khaled.animetriviaegycon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.animation;

public class StatusActivity extends Fragment {

    public StatusActivity() {
    }

    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content_status, container, false);

        final TextView HSLable = (TextView) view.findViewById(R.id.HighScoreLable);
        final TextView Fanimes = (TextView) view.findViewById(R.id.favanime);
        final TextView rightanslables = (TextView) view.findViewById(R.id.rightanslable);
        final TextView leaderboardlables = (TextView) view.findViewById(R.id.leaderboardlable);
        final TextView personalscores = (TextView) view.findViewById(R.id.personalscore);
        final TextView fanimu = (TextView) view.findViewById(R.id.favanimename);
        final TextView rans = (TextView) view.findViewById(R.id.rightans);
        final TextView rank = (TextView) view.findViewById(R.id.worldplace);

        //Animation Declaration
        Animation animation1 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.slide_in_left);
        Animation animation2 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.slide_in_left);
        Animation animation3 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.slide_in_left);
        Animation animation4 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.slide_in_left);
        Animation animation5 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);
        Animation animation6 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);
        Animation animation7 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);
        Animation animation8 = AnimationUtils.loadAnimation(getActivity(),android.R.anim.fade_in);

        //Animation Duration
        animation1.setDuration(200);
        animation2.setDuration(200);
        animation3.setDuration(200);
        animation4.setDuration(200);
        animation5.setDuration(200);
        animation6.setDuration(200);
        animation7.setDuration(200);
        animation8.setDuration(200);

        //Animation when to start
        animation2.setStartOffset(200);
        animation3.setStartOffset(400);
        animation4.setStartOffset(600);
        animation6.setStartOffset(200);
        animation7.setStartOffset(400);
        animation8.setStartOffset(600);

        //Animation start
        HSLable.startAnimation(animation1);
        Fanimes.startAnimation(animation2);
        rightanslables.startAnimation(animation3);
        leaderboardlables.startAnimation(animation4);
        personalscores.startAnimation(animation5);
        fanimu.startAnimation(animation6);
        rans.startAnimation(animation7);
        rank.startAnimation(animation8);


        setHasOptionsMenu(true);

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

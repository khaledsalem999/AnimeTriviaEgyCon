package com.example.khaled.animetriviaegycon;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Khaled on 12/8/2016.
 */
public class ImageAdapter extends BaseAdapter {
    ArrayList<Integer> selectedPosition = new ArrayList<Integer>();
    private ArrayList<Anime> anime;
    private LayoutInflater mInflater;
    Context context;
    FloatingActionButton button;
    View ParentView;

    public ImageAdapter(Context context, ArrayList<Anime> anime, View gridView) {
        this.context=context;
        this.anime=anime;
        ParentView=gridView;
    }

    @Override
    public int getCount() {
        return anime.size();
    }

    @Override
    public Object getItem(int i) {
        return anime.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View ConvertView, ViewGroup parent) {
        final AnimeViewHandler holder;

        if (mInflater == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            button = (FloatingActionButton) ParentView.findViewById(R.id.floatingActionButton);
            button.setImageResource(R.drawable.ic_menu_send);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    context.startActivity(new Intent(context, QuestionActivity.class));
                }
            });
        }
        if(ConvertView==null){
            ConvertView=mInflater.inflate(R.layout.grid_item,parent,false);
        }
            //holder = (AnimeViewHandler) ConvertView.getTag();

        holder = new AnimeViewHandler(ConvertView);
        holder.text.setText(anime.get(position).getname());
        ConvertView.setTag(holder);
        PicassoClient.downloadImage(context, anime.get(position).geturl(), holder.img);
        holder.text.setTag(position);
        adjustSelect(holder.text,selectedPosition.contains(position));

        ConvertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewClicked(holder,position);
            }
        });


        return ConvertView;
    }

    public void onViewClicked(AnimeViewHandler viewHolder, Integer position){
        if (selectedPosition.contains(position)) {
            adjustSelect(viewHolder.text, false);
                selectedPosition.remove(position);
            checkButton(ParentView,context);
        }
        else if(selectedPosition.contains(position)==false  && selectedPosition.size()<10) {
            adjustSelect(viewHolder.text, true);
            selectedPosition.add(position);
            checkButton(ParentView,context);
        }
    }

    public void adjustSelect(TextView text, boolean visible){
        if(visible) {
            text.setBackgroundColor(Color.parseColor("#304FFE"));
            text.setTextColor(Color.parseColor("#000000"));
        }
        else{
            text.setBackgroundColor(Color.parseColor("#55000000"));
            text.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    public void checkButton(View view, Context c){
        if(c!=null){
            if(selectedPosition.size()>9){
                button.setVisibility(ParentView.VISIBLE);
            }
            else if(selectedPosition.size()<10 && button!=null){
                button.setVisibility(ParentView.INVISIBLE);
            }
        }
    }


}

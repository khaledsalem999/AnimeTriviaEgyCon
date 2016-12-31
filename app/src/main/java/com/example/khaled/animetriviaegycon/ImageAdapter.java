package com.example.khaled.animetriviaegycon;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
    private final List<Item> mItems = new ArrayList<Item>();
    private ArrayList<Anime> anime;
    private LayoutInflater mInflater;
    Context context;

    public ImageAdapter(Context context, ArrayList<Anime> anime) {
        this.context=context;
        this.anime=anime;
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
    public View getView(int position, View ConvertView, ViewGroup parent) {
        if (mInflater == null) {
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(ConvertView==null){
            ConvertView=mInflater.inflate(R.layout.grid_item,parent,false);
        }

        final AnimeViewHandler holder = new AnimeViewHandler(ConvertView);
        holder.text.setText(anime.get(position).getname());
        PicassoClient.downloadImage(context, anime.get(position).geturl(), holder.img);

        return ConvertView;
    }




}

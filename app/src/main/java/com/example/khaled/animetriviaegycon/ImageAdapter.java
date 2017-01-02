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
    ArrayList<String> selectedAnime = new ArrayList<String>();
    ArrayList<Question> questionList = new ArrayList<Question>();
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

                    DatabaseReference ref= FirebaseDatabase.getInstance().getReference("questions");
                    for(int i=0; i<20; i++){
                        final int finalI = i;
                        ref.orderByChild("0").equalTo(selectedAnime.get(i)).addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String keyStart= dataSnapshot.getChildren().iterator().next().getKey().toString();
                                int index;
                                Question newQuestion;

                                while(true) {
                                    index = (int) (Integer.parseInt(keyStart) + Math.random() * dataSnapshot.getChildrenCount());
                                    String questionText = dataSnapshot.child(Integer.toString(index)).child("2").getValue().toString();
                                    String ans1 = dataSnapshot.child(Integer.toString(index)).child("3").getValue().toString();
                                    String ans2 = dataSnapshot.child(Integer.toString(index)).child("4").getValue().toString();
                                    String ans3 = dataSnapshot.child(Integer.toString(index)).child("5").getValue().toString();
                                    String name = dataSnapshot.child(Integer.toString(index)).child("0").getValue().toString();
                                    String url =  dataSnapshot.child(Integer.toString(index)).child("6").getValue().toString();
                                    newQuestion = new Question(name, questionText, ans1, ans2, ans3, url);

                                    if(questionList.contains(newQuestion) && newQuestion!=null){
                                        continue;
                                    }
                                    else{
                                        questionList.add(newQuestion);
                                        break;
                                    }
                                }

                                if(questionList.size()==20){
                                    Intent quiz = new Intent(context, QuestionActivity.class);
                                    int counter=0;
                                    long millis=0;
                                    quiz.putExtra("Counter", counter);
                                    quiz.putExtra("Questions", questionList);
                                    quiz.putExtra("Time",millis);
                                    context.startActivity(quiz);
                                }

                                //dataSnapshot.child(Integer.toString(index)).getChildren().iterator().next().child("2").getValue().toString()
                            }
                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
                    }
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
            selectedAnime.remove(anime.get(position).getname());
            selectedAnime.remove(anime.get(position).getname());
            checkButton(ParentView,context);
        }
        else if(selectedPosition.contains(position)==false  && selectedPosition.size()<10) {
            adjustSelect(viewHolder.text, true);
            selectedPosition.add(position);
            selectedAnime.add(anime.get(position).getname());
            selectedAnime.add(anime.get(position).getname());
            checkButton(ParentView,context);
        }
    }

    public void adjustSelect(TextView text, boolean visible){
        if(visible) {
            text.setBackgroundColor(Color.parseColor("#7E2856"));
            text.setTextColor(Color.parseColor("#FFFFFF"));
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

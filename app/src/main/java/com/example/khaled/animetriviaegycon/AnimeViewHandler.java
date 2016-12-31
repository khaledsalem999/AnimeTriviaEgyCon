package com.example.khaled.animetriviaegycon;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hyhae on 12/31/2016.
 */

public class AnimeViewHandler {
    TextView text;
    ImageView img;

    public AnimeViewHandler(View itemView){
        text = (TextView) itemView.findViewById(R.id.text);
        img= (ImageView) itemView.findViewById(R.id.picture);
    }

}

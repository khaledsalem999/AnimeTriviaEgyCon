package com.example.khaled.animetriviaegycon;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by hyhae on 12/31/2016.
 */

public class PicassoClient {
    public static void downloadImage(Context c, String url, ImageView img){
        if(url != null && url.length()>0){
            Picasso.with(c).load(url).placeholder(R.mipmap.placeholder).into(img);
        }
        else{
            Picasso.with(c).load(R.mipmap.placeholder).into(img);
        }
    }
}

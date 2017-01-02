package com.example.khaled.animetriviaegycon;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final ImageView Splashaya = (ImageView) findViewById(R.id.splashaya);
        final Animation SplashIN = AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        final Animation SplashOUT = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);

        Splashaya.startAnimation(SplashIN);
        SplashIN.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Splashaya.startAnimation(SplashOUT);
                        finish();
                        Intent LoGIn = new Intent(getBaseContext(),LoginActivity.class);
                        startActivity(LoGIn);
                    }
                }, 5000);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}

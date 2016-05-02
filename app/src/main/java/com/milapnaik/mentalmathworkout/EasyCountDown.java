package com.milapnaik.mentalmathworkout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;

/**
 * Created by MilapNaik on 5/2/16.
 */
public class EasyCountDown extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecd);
        final ImageView one = (ImageView) findViewById(R.id.imageone);
        ImageView two = (ImageView) findViewById(R.id.imagetwo);
        ImageView three = (ImageView) findViewById(R.id.imagethree);
        final Animation fadeout = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);
        final Animation fadein = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_in);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(1000);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);

        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        three.setAnimation(animation);

        /*Animate number two*/
        Animation fadeIn2 = new AlphaAnimation(0, 1);
        fadeIn2.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn2.setStartOffset(3000);
        fadeIn2.setDuration(1000);

        Animation fadeOut2 = new AlphaAnimation(1, 0);
        fadeOut2.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut2.setStartOffset(1000);
        fadeOut2.setDuration(1000);

        AnimationSet animation2 = new AnimationSet(false); //change to false
        animation2.addAnimation(fadeIn);
        animation2.addAnimation(fadeOut);
        two.setAnimation(animation);
        //one.setAnimation(animation);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(EasyCountDown.this, MathTest.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}

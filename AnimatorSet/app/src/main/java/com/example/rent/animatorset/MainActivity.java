package com.example.rent.animatorset;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.guzik);
       ObjectAnimator translateAnimation = ObjectAnimator.ofFloat(button, View.TRANSLATION_X, 0, 100);
        translateAnimation.setDuration(2000);
        ObjectAnimator rotateAnimation = ObjectAnimator.ofFloat(button, View.ROTATION, 0, 180);
        rotateAnimation.setDuration(2000);
        ObjectAnimator scaleAnimation = ObjectAnimator.ofFloat(button, View.SCALE_X, 0, 10);
        scaleAnimation.setDuration(2000);

        AnimatorSet animatorSet =new AnimatorSet();
        animatorSet.playSequentially(translateAnimation, rotateAnimation, scaleAnimation);
        animatorSet.start();
    }
}

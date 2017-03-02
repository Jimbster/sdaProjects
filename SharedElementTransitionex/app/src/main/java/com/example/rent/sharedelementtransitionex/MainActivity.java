package com.example.rent.sharedelementtransitionex;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView smallImage = (ImageView) findViewById(R.id.dino);
        smallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, smallImage, "dinotransition");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent, optionsCompat.toBundle());
            }
        });
    }
}

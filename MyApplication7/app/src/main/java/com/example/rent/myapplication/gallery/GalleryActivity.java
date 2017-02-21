package com.example.rent.myapplication.gallery;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rent.myapplication.R;
import com.example.rent.myapplication.drawing.DrawingActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by RENT on 2017-02-21.
 */

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_activity);
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        File dir = getExternalFilesDir(DrawingActivity.DRAWING_GALLERY);
        File [] files = dir.listFiles();
        viewPager.setAdapter(new DrawingPagerAdapter(files));

    }
}

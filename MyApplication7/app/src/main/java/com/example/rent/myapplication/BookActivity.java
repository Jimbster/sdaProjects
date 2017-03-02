package com.example.rent.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by RENT on 2017-03-02.
 */

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_layout);

        ViewPager viewPager = (ViewPager) findViewById(R.id.books_viewpager);
        TabLayout tabLayout= (TabLayout) findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(viewPager);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        Book effectivejava = new Book(1, R.drawable.effectivejava, "Effective Java");
        effectivejava.setRead(sharedPreferences.getBoolean(String.valueOf(effectivejava.getId()), false));
        Book cleancode = new Book (2, R.drawable.cleancode, "Clean Code");
        cleancode.setRead(sharedPreferences.getBoolean(String.valueOf(cleancode.getId()), false));
        Book headfirst = new Book (3, R.drawable.headkurwa, "Headfirst Lodzia");
        headfirst.setRead(sharedPreferences.getBoolean(String.valueOf(headfirst.getId()), false));
        List<Book> list = Arrays.asList(effectivejava, cleancode, headfirst);


        BooksPagerAdapter adapter = new BooksPagerAdapter(list, sharedPreferences);
        viewPager.setAdapter(adapter);
    }
}

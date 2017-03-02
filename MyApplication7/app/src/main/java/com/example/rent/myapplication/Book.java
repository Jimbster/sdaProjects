package com.example.rent.myapplication;

import android.content.SharedPreferences;
import android.support.annotation.DrawableRes;

/**
 * Created by RENT on 2017-03-02.
 */
public class Book {



    private int id;

    private boolean isRead;

    public int getId() {
        return id;
    }

    @DrawableRes
    private int imageResourceId;

    private String title;

    @DrawableRes
    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public Book(int id, @DrawableRes int imageResourceId, String title) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.title = title;

    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {

        isRead = read;
    }
}

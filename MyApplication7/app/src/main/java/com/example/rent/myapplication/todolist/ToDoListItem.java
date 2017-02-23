package com.example.rent.myapplication.todolist;

/**
 * Created by RENT on 2017-02-23.
 */

public class ToDoListItem {

    public ToDoListItem(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean orNot) {
        isChecked = orNot;
    }

    private String text;
    private boolean isChecked;
}

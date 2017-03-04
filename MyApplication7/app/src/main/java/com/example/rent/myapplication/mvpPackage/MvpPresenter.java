package com.example.rent.myapplication.mvpPackage;

import android.os.Handler;

import nucleus.presenter.Presenter;

/**
 * Created by RENT on 2017-03-04.
 */
public class MvpPresenter extends Presenter<MvpActivity> {

    private LongRunningTask longRunningTask = new LongRunningTask();


    public void executeLongRunningTask () {
        new Thread() {
            public void run() {
                final String result = longRunningTask.execute();

            }
        }.start();
    }
}

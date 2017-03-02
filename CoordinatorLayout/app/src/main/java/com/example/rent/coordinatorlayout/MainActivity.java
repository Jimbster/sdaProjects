package com.example.rent.coordinatorlayout;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CardView cardView = (CardView) findViewById(R.id.redcardview);
        SwipeDismissBehavior <CardView> swipeDismissBehavior = new SwipeDismissBehavior<CardView>();
        swipeDismissBehavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                Toast.makeText(MainActivity.this, "wypierdolon!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDragStateChanged(int state) {

            }
        });
        CoordinatorLayout.LayoutParams layoutParams= (CoordinatorLayout.LayoutParams) cardView.getLayoutParams();
        layoutParams.setBehavior(swipeDismissBehavior);

    }

}

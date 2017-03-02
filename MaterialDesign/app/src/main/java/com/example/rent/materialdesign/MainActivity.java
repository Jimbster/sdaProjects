package com.example.rent.materialdesign;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.renderscript.Sampler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText editTextLogin = (EditText) findViewById(R.id.login);
        final EditText editTextPassword = (EditText) findViewById(R.id.password);
        final TextInputLayout logininputlayout = (TextInputLayout) findViewById(R.id.inputlayoutlogin);
        final TextInputLayout passwordinputlayout = (TextInputLayout) findViewById(R.id.inputlayoutpassword);
        Button button = (Button) findViewById(R.id.guzik);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isWrong = false;
                if (editTextLogin.getText().toString().isEmpty() || !editTextLogin.getText().toString().contains(("@"))) {
                    logininputlayout.setError("Niepoprawny Login");
                    isWrong = true;
                }
                if (editTextPassword.getText().toString().isEmpty()) {
                    passwordinputlayout.setError("Puste Haslo");
                    isWrong = true;
                }
                if (isWrong) {
                    Snackbar.make(v, "ZLE HASLO ALBO LOGIN SNACK", Snackbar.LENGTH_INDEFINITE)
                            .setAction("close", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            })
                            .show();
//                    Toast.makeText(MainActivity.this, "Login lub hasło jest niepoprawne", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //seterror na edittexcie


//        final View button = (View) findViewById(R.id.guzik);
//        final ValueAnimator animator = ObjectAnimator.ofFloat(0, 130);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                button.setElevation((float)animation.getAnimatedValue());
//            }
//        });
//
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//            @Override
//            public void onClick(View v) {
//                animator.start();
//            }
//        });
    }
}

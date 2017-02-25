package com.example.rent.myapplication.quiz;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rent.myapplication.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by RENT on 2017-02-25.
 */

public class QuizActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    TextView polepytan;
    ProgressBar progressBar;

    String question;
    String answer1;
    String answer2;
    String answer3;
    String answer4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milionerzy);


        button1 = (Button) findViewById(R.id.odp1);
        button2 = (Button) findViewById(R.id.odp2);
        button3 = (Button) findViewById(R.id.odp3);
        button4 = (Button) findViewById(R.id.odp4);

        polepytan = (TextView) findViewById(R.id.milionerzy_tekst);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        ValueAnimator objectAnimator = ObjectAnimator.ofInt(0, 100);
        objectAnimator.setDuration(10000);

        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                progressBar.setProgress((Integer) animation.getAnimatedValue());
            }
        });
        objectAnimator.start();
        String json = null;
        try {
            json = loadQuiz();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, json, Toast.LENGTH_LONG).show();

    }


    private String loadQuiz() throws IOException {
        StringBuilder buf = new StringBuilder();

        InputStream json = getAssets().open("quiz_data.json");
        BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
        String str;
        while ((str = in.readLine()) != null) {
            buf.append(str);
        }

        in.close();
        return buf.toString();
    }


}

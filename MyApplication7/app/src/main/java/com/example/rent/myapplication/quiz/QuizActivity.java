package com.example.rent.myapplication.quiz;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rent.myapplication.R;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by RENT on 2017-02-25.
 */

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String INDEX_KEY = "index_key";
    private int currentQuestionIndex;
    private static int wynik=0;

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    TextView polewyniku;

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

        currentQuestionIndex = getIntent().getIntExtra(INDEX_KEY, 0);


        button1 = (Button) findViewById(R.id.odp1);
        button2 = (Button) findViewById(R.id.odp2);
        button3 = (Button) findViewById(R.id.odp3);
        button4 = (Button) findViewById(R.id.odp4);

        polepytan = (TextView) findViewById(R.id.milionerzy_tekst);
        polewyniku = (TextView) findViewById(R.id.pole_wyniku);
        polewyniku.setText(getString(R.string.wynik_string, wynik));
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
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {


                if (currentQuestionIndex < 1) {
                    Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                    intent.putExtra(INDEX_KEY, ++currentQuestionIndex);
                    startActivity(intent);
                }


            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        String json = null;
        try {
            json = loadQuizJson();
            QuizContainer quizContainer = new Gson().fromJson(json, QuizContainer.class);

            polepytan.setText(quizContainer.getQuestions().get(currentQuestionIndex).getQuestion());

            SingleAnswer firstAnswer = quizContainer.getQuestions().get(currentQuestionIndex).getAnswers().get(0);
            button1.setText(firstAnswer.getText());
            button1.setTag(firstAnswer.isCorrect());

            SingleAnswer secondAnswer = quizContainer.getQuestions().get(currentQuestionIndex).getAnswers().get(1);
            button2.setTag(secondAnswer.isCorrect());
            button2.setText(secondAnswer.getText());

            SingleAnswer thirdAnswer = quizContainer.getQuestions().get(currentQuestionIndex).getAnswers().get(2);
            button3.setText(thirdAnswer.getText());
            button3.setTag(thirdAnswer.isCorrect());

            SingleAnswer fourthAnswer = quizContainer.getQuestions().get(currentQuestionIndex).getAnswers().get(3);
            button4.setText(fourthAnswer.getText());
            button4.setTag(fourthAnswer.isCorrect());

            button1.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            button4.setOnClickListener(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        Toast.makeText(this, json, Toast.LENGTH_LONG).show();

    }


    private String loadQuizJson() throws IOException {
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


    @Override
    public void onClick(View v) {
        if ((Boolean) v.getTag()) {
            Toast.makeText(this, "DOBRZE!", Toast.LENGTH_LONG).show();
            v.setBackgroundColor(Color.GREEN);
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
            mediaPlayer.start();
            wynik++;
            polewyniku.setText(getString(R.string.wynik_string, wynik));
        } else {
            Toast.makeText(this, "ZLE!", Toast.LENGTH_LONG).show();
        }

        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (currentQuestionIndex < 1) {
                    Intent intent = new Intent(QuizActivity.this, QuizActivity.class);
                    intent.putExtra(INDEX_KEY, ++currentQuestionIndex);
                    startActivity(intent);

                }
            }
        }, 3000);

    }


}

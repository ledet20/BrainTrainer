package com.ledetawano.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameTrainer extends AppCompatActivity {


    TextView secondsRemain;
    TextView scoreCount;
    TextView multiplyValues;
    Button topLeft;
    Button topRight;
    Button bottomLeft;
    ArrayList<Integer> randValues = new ArrayList<>();
    Button bottomRight;
    int totalClicked = 1;
    int totalVal = 0;
    int totalCorrect = 0;
    Random rand = new Random();
    Random r = new Random();
    int correctAnswerIndex;

    public int setTotalClicked() {
        return totalClicked++;
    }

    // function that generate random values to be multiplied
    public int randomMultiplyVal() {
        int randVal = rand.nextInt(14) + 1;
        return randVal;
    }

    public void getRandomValue() {
        int val1 = randomMultiplyVal();
        int val2 = randomMultiplyVal();

        multiplyValues.setText(Integer.toString(val1) + "*" + Integer.toString(val2));

        correctAnswerIndex = rand.nextInt(4);

        int incorrectAnswer;

        for(int i = 0; i < 4; i++) {
            if( correctAnswerIndex == i) {
                randValues.add(val1 * val2);
            }
            else {
                incorrectAnswer = rand.nextInt(200) + 1;
                randValues.add(incorrectAnswer);
            }
        }

        bottomRight.setText(Integer.toString(randValues.get(3)));
        bottomLeft.setText(Integer.toString(randValues.get(2)));
        topLeft.setText(Integer.toString(randValues.get(0)));
        topRight.setText(Integer.toString(randValues.get(1)));

        randValues.clear();

        totalVal = setTotalClicked();
    }


    public void valueChange(View view) {

        if(view.getTag().toString().equals(Integer.toString(correctAnswerIndex))) {
            totalCorrect++;
        }


        scoreCount.setText(Integer.toString(totalCorrect) + "/" + Integer.toString(totalVal));

        getRandomValue();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_trainer);

        secondsRemain = (TextView) findViewById(R.id.secondsRemain);
        scoreCount = (TextView) findViewById(R.id.scoreCount);
        multiplyValues = (TextView) findViewById(R.id.multiplyVal);
        topLeft = (Button) findViewById(R.id.topLeft);
        topRight = (Button) findViewById(R.id.topRight);
        bottomLeft = (Button) findViewById(R.id.bottomLeft);
        bottomRight = (Button) findViewById(R.id.bottomRight);


        getRandomValue();


        // timer that runs for 30 seconds, when the time is up the game is over
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                secondsRemain.setText(Integer.toString((int) millisUntilFinished / 1000));
            }

            public void onFinish() {
                secondsRemain.setText("0");
            }
        }.start();

    }
}

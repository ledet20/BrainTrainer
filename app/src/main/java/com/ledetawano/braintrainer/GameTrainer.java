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

/**
 * Created by ledet awano on 12/30/2017.
 */

public class GameTrainer extends AppCompatActivity {

    TextView secondsRemain;
    TextView scoreCount;
    TextView multiplyValues;
    Button topLeft;
    Button topRight;
    Button bottomLeft;
    Button bottomRight;
    int totalClicked = 1;
    int totalVal = 0;
    int totalCorrect = 1;
    Random rand = new Random();

    public int setTotalClicked() {
        return totalClicked++;
    }

    public int addTotalCorrect() {
        return totalCorrect++;
    }

    public int randomMultiplyVal() {
        int randVal = rand.nextInt(14) + 1;
        return randVal;
    }

    public int getRandomNum(List<Integer> list) {

        int index = rand.nextInt(list.size());
        return list.get(index);
    }

    public void valueChange(View view) {

        int randVal1 = randomMultiplyVal();
        int randVal2 = randomMultiplyVal();

        int randNum = rand.nextInt(200) + 1;
        int randNum1 = rand.nextInt(200) + 1;
        int randNum2 = rand.nextInt(200) + 1;
        int multiplyAnswer = randVal1 * randVal2;
        int totalCorrect = 0;

        List<Integer> randValues = new ArrayList<>();
        randValues.add(randNum);
        randValues.add(randNum1);
        randValues.add(randNum2);
        randValues.add(multiplyAnswer);

        bottomRight.setText(Integer.toString(getRandomNum(randValues)));
        topRight.setText(Integer.toString(getRandomNum(randValues)));
        topLeft.setText(Integer.toString(getRandomNum(randValues)));
        bottomLeft.setText(Integer.toString(getRandomNum(randValues)));

        totalVal = setTotalClicked();

        multiplyValues.setText(Integer.toString(randVal1) + "*" + Integer.toString(randVal2) );

        Button b = (Button)view;
        String buttonText = b.getText().toString();

        if(buttonText.equals(Integer.toString(multiplyAnswer))) {
            totalCorrect = addTotalCorrect();
        }

        scoreCount.setText(Integer.toString(totalCorrect ) + "/" + Integer.toString(totalVal));

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


        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                //  mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                 secondsRemain.setText(Integer.toString(  (int) millisUntilFinished / 1000));
            }

            public void onFinish() {
                secondsRemain.setText("0");
            }
        }.start();

    }
}

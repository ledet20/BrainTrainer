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

<<<<<<< HEAD

public class GameTrainer extends AppCompatActivity {
>>>>>>> a4a9bf13cd30eae20859941be6d7b0a8f2494271

=======
public class GameTrainer extends AppCompatActivity {
>>>>>>> a4a9bf13cd30eae20859941be6d7b0a8f2494271

    TextView secondsRemain;
    TextView scoreCount;
    TextView multiplyValues;
    Button topLeft;
    Button topRight;
    Button bottomLeft;
    List<Integer> randValues;
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

    public int valueChangeOnClick(View view) {

        int randVal1 = randomMultiplyVal();
        int randVal2 = randomMultiplyVal();
        int multiplyAnswer = randVal1 * randVal2;
        int incorrectAnswer;


        // stores a rand index value from 0-3 and then in teh for loop checks if the index values match
        correctAnswerIndex = rand.nextInt(4);

        randValues = new ArrayList<Integer>();

        // for loop that add values to the arrayList

        for (int i = 0; i < 4; i++) {
            if (i == correctAnswerIndex) {

                randValues.add(multiplyAnswer);

            } else {
                incorrectAnswer = r.nextInt(200) + 1;
                randValues.add(incorrectAnswer);
            }

        }

        // adds random values to the buttons
        if (view.getId() == bottomRight.getId()) {
            bottomRight.setText(Integer.toString(randValues.get(0)));
        } else if (view.getId() == topRight.getId()) {
            topRight.setText(Integer.toString(randValues.get(1)));
        } else if (view.getId() == topLeft.getId()) {
            topLeft.setText(Integer.toString(randValues.get(2)));
        } else if (view.getId() == bottomLeft.getId()) {
            bottomLeft.setText(Integer.toString(randValues.get(3)));
        }

        totalVal = setTotalClicked();

        multiplyValues.setText(Integer.toString(randVal1) + "*" + Integer.toString(randVal2));


        // if statement that checks if the current button tag is eqaul to the answer index
        // currently this implentation is not working
        // if(view.toString().equals(Integer.toString(multiplyAnswer))){
        //   totalCorrect++;
        //   Log.i("the value is" , "CORREC");
        // }

        scoreCount.setText(Integer.toString(totalCorrect) + "/" + Integer.toString(totalVal));

        return multiplyAnswer;

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


        topLeft.setOnClickListener(new View.OnClickListener(

        ) {


            @Override
            public void onClick(View view) {

                // returns multiplied value generated from function
                int val = valueChangeOnClick(view);

                // get the text of the current button
                topLeft = (Button) view;
                String buttonText = topLeft.getText().toString();

                //  Log.i("top Left Val", Integer.toString(val));
                Log.i("button text", buttonText);
                Log.i("multiplied val", Integer.toString(val));

                if (buttonText.equals(Integer.toString(val))) {
                    Log.i("top Left Val", Integer.toString(val));
                    totalCorrect++;
                }



            }
        });

        topRight.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View view) {

                int val = valueChangeOnClick(view);

                topRight = (Button) view;
                String buttonText = topRight.getText().toString();

                //  Log.i("top Left Val", Integer.toString(val));
                Log.i("button text", buttonText);
                Log.i("multiplied val", Integer.toString(val));

                if (buttonText.equals(Integer.toString(val))) {
                    Log.i("top Right Val", Integer.toString(val));
                    totalCorrect++;
                }



            }
        });

        bottomLeft.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View view) {

                int val = valueChangeOnClick(view);

                bottomLeft = (Button) view;
                String buttonText = bottomLeft.getText().toString();

                //  Log.i("top Left Val", Integer.toString(val));
                Log.i("button text", buttonText);
                Log.i("multiplied val", Integer.toString(val));

                if (buttonText.equals(Integer.toString(val))) {
                    Log.i("bottom left Val", Integer.toString(val));
                    totalCorrect++;
                }



            }
        });

        bottomRight.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View view) {

                int val = valueChangeOnClick(view);

                bottomRight = (Button) view;
                String buttonText = bottomRight.getText().toString();

                //  Log.i("top Left Val", Integer.toString(val));
                Log.i("button text", buttonText);
                Log.i("multiplied val", Integer.toString(val));

                if (buttonText.equals(Integer.toString(val))) {
                    Log.i("bottom Right Val", Integer.toString(val));
                    totalCorrect++;
                }



            }
        });

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

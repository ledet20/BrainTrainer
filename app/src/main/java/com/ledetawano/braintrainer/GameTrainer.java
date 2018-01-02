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
     List<Integer> randValues;
     Button bottomRight;
     int totalClicked = 1;
     int totalVal = 0;
     int totalCorrect = 0;
     Random rand = new Random();
     Random r = new Random();
     int correctAnswerIndex;

     // function that increaments count when button is clicked
     public int setTotalClicked() {
         return totalClicked++;
     }


     // function that generate random values to be multiplied
     public int randomMultiplyVal() {
         int randVal = rand.nextInt(14) + 1;
         return randVal;
     }

     // on click function for the four button that update the score and generate a new random values and multiply values
     public void valueChange(View view) {

         int randVal1 = randomMultiplyVal();
         int randVal2 = randomMultiplyVal();
         int multiplyAnswer = randVal1 * randVal2;
         int incorrectAnswer;

         // stores a rand index value from 0-3 and then in teh for loop checks if the index values match
         correctAnswerIndex = rand.nextInt(4);

         Button b = (Button)view;
         String buttonText = b.getText().toString();

          randValues = new ArrayList<Integer>();

         // for loop that add values to the arrayList
         for(int i = 0; i < 4; i++) {
             if(i == correctAnswerIndex) {
                 randValues.add(multiplyAnswer);
                 Log.i("correct Answe", Integer.toString(correctAnswerIndex));
             } else {
                 incorrectAnswer = r.nextInt(200) + 1;
                 randValues.add(incorrectAnswer);
             }

         }

         Log.i("button text", buttonText);

         if(randValues.get(correctAnswerIndex).toString().equals(buttonText)) {
             //correctAnswerIndex = i;
             Log.i("correct index!!", Integer.toString(correctAnswerIndex));
         }

         totalVal = setTotalClicked();

         multiplyValues.setText(Integer.toString(randVal1) + "*" + Integer.toString(randVal2) );

         Log.i("tag", (String) view.getTag());


         // if statement that checks if the current button tag is eqaul to the answer index
         // currently this implentation is not working
         if(view.getTag().toString().equals(Integer.toString(correctAnswerIndex))){
           totalCorrect+=1;
          //   Log.i("tag val inside",  ((Button) view).getText().toString());
         }

         Log.i("tag val outside if",  ((Button) view).getText().toString());

         scoreCount.setText(Integer.toString(totalCorrect) + "/" + Integer.toString(totalVal));


         // adds random values to the buttons
         bottomRight.setText(Integer.toString(randValues.get(0)));
         topRight.setText(Integer.toString(randValues.get(1)));
         topLeft.setText(Integer.toString(randValues.get(2)));
         bottomLeft.setText(Integer.toString(randValues.get(3)));



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


         // timer that runs for 30 seconds, when the time is up the game is over
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

package com.ledetawano.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button begin;

    public void beginGame(View view) {

        begin.setVisibility(View.INVISIBLE);

        Intent i = new Intent(this, GameTrainer.class);

        startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        begin = (Button) findViewById(R.id.begin);

    }
}

package com.chandler.android.aca.pong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends Activity{

    public TextView mYouLose;
    Button mPlay;
    Button mHighScores;
    Button mMemes;
    GameView mGameView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mYouLose = (TextView) findViewById(R.id.textView);

        mPlay = (Button) findViewById(R.id.btnPlay);
      //  mHighScores = (Button) findViewById(R.id.btnHighScores);
      //  mMemes = (Button) findViewById(R.id.btnMemes);


        //set onClick listener to populate gameView after a click
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent game = new Intent(Home.this, MainActivity.class);
                startActivity(game);

                //set gameView as the view
                //setContentView(gameView);
            }
        });
/*
        mHighScores.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent highScoreIntent = new Intent(Home.this, HighScores.class);
                startActivity(highScoreIntent);
            }
        });

        mMemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent memeIntent = new Intent(Home.this, Memes.class);
                startActivity(memeIntent);
            }
        });*/

    }

}


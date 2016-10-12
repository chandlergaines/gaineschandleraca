package com.chandler.android.aca.pong;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends Activity{

    Button mPlay;
    Button mHighScores;
    Button mMemes;
    TextView mYouLose;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);


        mYouLose = (TextView) findViewById(R.id.textView);

        mPlay = (Button) findViewById(R.id.btnPlay);
        mHighScores = (Button) findViewById(R.id.btnHighScores);
        mMemes = (Button) findViewById(R.id.btnMemes);

        //set onClick listener to populate gameView after a click
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent game = new Intent(GameOver.this, MainActivity.class);
                startActivity(game);

                //set gameView as the view
                //setContentView(gameView);
            }
        });

        mHighScores.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent highScoreIntent = new Intent(GameOver.this, HighScores.class);
                startActivity(highScoreIntent);
            }
        });

        mMemes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent memeIntent = new Intent(GameOver.this, Memes.class);
                startActivity(memeIntent);
            }
        });
    }
}

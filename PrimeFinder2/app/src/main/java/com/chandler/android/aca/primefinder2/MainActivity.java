package com.chandler.android.aca.primefinder2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public long target;
    public long prime;
    public boolean finished;
    private Thread runner;

    MainActivity(long inTarget){
        target = inTarget;
        if (runner == null){
            runner = new Thread();
            runner.start(); //when we call runner.start, public run() gets called
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}

package com.chandler.android.aca.marsrobot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MarsRobot spirit = new MarsRobot();

        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature = -60;
        spirit.charged = true;
        spirit.scared = false;

        spirit.showAttributes();
        System.out.println("Increasing speed to 3.");
        spirit.speed = 3;
        spirit.showAttributes();
        System.out.println("Changing temperature to -90.");
        spirit.temperature = -90;
        spirit.showAttributes();
        System.out.println("Checking the temperature.");
        spirit.checkTemperature();
        spirit.showAttributes();

        //emerald coding begins

        MarsRobot emerald = new MarsRobot();

        emerald.status = "anxious and lonely...";
        emerald.speed = 3;
        emerald.temperature = -50;
        emerald.charged = true;

        emerald.showAttributes();
        System.out.println("Too hot. Changing temperature to -70.");
        emerald.temperature = -70;
        emerald.showAttributes();
        System.out.println("Is it any cooler yet?!");
        emerald.checkTemperature();
        emerald.showAttributes();
        System.out.println("What was that?!");
        emerald.scared = true;
        emerald.runAway();


    }
}

package com.chandler.android.aca.marsrobot;

/**
 * Created by chandlergaines on 8/24/16.
 */
public class MarsRobot {
    String status;
    int speed;
    float temperature;
    boolean charged;
    boolean scared;


    void checkTemperature () {
        if (temperature < -80) { //if this isn't true, skip following bracket code
            status = "returning home";
            speed = 5;
        }
    }

    void showAttributes () {
        System.out.println("Status: " + status);
        System.out.println("Speed: " + speed);
        System.out.println("Temperature: " + temperature);
        System.out.println("Charged: ");
    }


    void runAway () {
        if ((charged = true) && (scared = true)) {
            status = "AHHHHHHHHH!!";
            System.out.println(status);
            speed = 45;
        }
    }}
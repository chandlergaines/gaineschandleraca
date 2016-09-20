package com.chandler.android.aca.daycounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import utils.DayCounter;

public class MainActivity extends AppCompatActivity {

    DayCounter mDayCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDayCounter = new DayCounter();

        int yearIn = 2016;


        for (int month = 1; month < 13; month++) {
            for (int day = 1; day <= mDayCounter.countDays(month, yearIn); day++) {
                System.out.println(month + "/" + day + "/" + yearIn);
            }
        }
    }

    /*

    This has been commented out in the process of learning how to use multiple packages. Text has been added to utils package

    // This is a method, inside the parens is the argument
    private int countDays(int month, int year) {
        int count = -1;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                count = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                count = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    count = 29;
                } else {
                    count = 28;
                }

                if ((year % 100 == 0) && (year % 400 != 0)) {
                    count = 28;
                }
        }
        return count;
    }
*/

}



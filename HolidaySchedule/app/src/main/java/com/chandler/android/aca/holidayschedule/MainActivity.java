package com.chandler.android.aca.holidayschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.BitSet;

public class MainActivity extends AppCompatActivity {

    EditText mDay;
    EditText mMonth;
    TextView mOutput;
    Button mButton;

    BitSet sked;

    HolidaySchedule cal = new HolidaySchedule();
    String day = "2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOutput = (TextView) findViewById(R.id.output);
        mMonth = (EditText) findViewById(R.id.month);
        mDay = (EditText) findViewById(R.id.day);
        mButton = (Button) findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String month;
                String day;
                int dayIn;

                month = mMonth.getText().toString();
                day = mDay.getText().toString();
                dayIn = 0;

                if (month.equals("1")) {
                    dayIn = Integer.parseInt(day);
                } else if (month.equals("2")) {
                    dayIn = 31 + Integer.parseInt(day);
                } else if (month.equals("3")) {
                    dayIn = 59 + Integer.parseInt(day);
                } else if (month.equals("4")) {
                    dayIn = 90 + Integer.parseInt(day);
                } else if (month.equals("5")) {
                    dayIn = 120 + Integer.parseInt(day);
                } else if (month.equals("6")) {
                    dayIn = 151 + Integer.parseInt(day);
                } else if (month.equals("7")) {
                    dayIn = 181 + Integer.parseInt(day);
                } else if (month.equals("8")) {
                    dayIn = 212 + Integer.parseInt(day);
                } else if (month.equals("9")) {
                    dayIn = 243 + Integer.parseInt(day);
                } else if (month.equals("10")) {
                    dayIn = 273 + Integer.parseInt(day);
                } else if (month.equals("11")) {
                    dayIn = 304 + Integer.parseInt(day);
                } else if (month.equals("12")) {
                    dayIn = 334 + Integer.parseInt(day);
                } else {mOutput.setText("Error");}

                if (cal.isHoliday(dayIn)) {
                    mOutput.setText("It's a holiday!");
                } else if (!cal.isHoliday(dayIn)) {
                    mOutput.setText("Sorry...that's not a holiday.");
                } else { mOutput.setText("Format Error");}
               /* if (cal.isHoliday(dayIn)){
                    try {
                        int whichDay = dayIn;
                        if (cal.isHoliday(whichDay)) {
                            mOutput.setText("Day number " + dayIn +
                                    " is a holiday.");
                        } else {
                            mOutput.setText("Day number " + dayIn +
                                    " is not a holiday.");
                        }
                    } catch (NumberFormatException nfe) {
                        mOutput.setText("Error: " + nfe.getMessage());
                    }
                } */
            }
        });


    }

    public class HolidaySchedule {
        BitSet sked;

        public HolidaySchedule() {
            sked = new BitSet(365);
            int[] holiday = { 1, 15, 50, 148, 185, 246,
                    281, 316, 326, 359 };

            for (int i = 0; i < holiday.length; i++) {
                addHoliday(holiday[i]);
            }
        }

        public void addHoliday(int dayToAdd) { //method to add holiday
            sked.set(dayToAdd); // (bitset name).(set to true)((day getting added "(holiday[i])")
            //we are telling the method to add shit to the bitset I think
        }

        public boolean isHoliday(int dayToCheck) { //method to check if its a holiday
            return sked.get(dayToCheck); //return true or false
        }
    }


}

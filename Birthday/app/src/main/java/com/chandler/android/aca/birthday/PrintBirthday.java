package com.chandler.android.aca.birthday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PrintBirthday extends AppCompatActivity {

    TextView mMonth;
    TextView mDay;
    TextView mYear;

    TextView mHeight;
    TextView mWeight;
    TextView mDepth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_birthday);

        mMonth = (TextView) findViewById(R.id.monthText);
        mDay = (TextView) findViewById(R.id.dayText);
        mYear = (TextView) findViewById(R.id.yearText);

        String birthday = new String ("02/24/1993");

        mMonth.setText(birthday.substring(0,2));
        mDay.setText(birthday.substring(3,5));
        mYear.setText(birthday.substring(6));

        Person chandler = new Person();

        TextView mHeight;
        TextView mWeight;
        TextView mDepth;

        mHeight = (TextView) findViewById(R.id.heightText);
        mWeight = (TextView) findViewById(R.id.weightText);
        mDepth = (TextView) findViewById(R.id.depthText);

        chandler.height = 69;
        chandler.weight = 145;
        chandler.depth = 0;

        Integer.toString(chandler.height);
        Integer.toString(chandler.weight);
        Integer.toString(chandler.depth);

       mHeight.setText(Integer.toString(chandler.height) + " inches");
       mWeight.setText(Integer.toString(chandler.weight) + " pounds");
       mDepth.setText(Integer.toString(chandler.depth) + " fucks");

    }}



package com.chandler.android.aca.temperatureconversion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mFah;
    TextView mCel;
    TextView mOutputTextView;
    Button mConvertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFah = (TextView) findViewById(R.id.fahText);
        mCel = (TextView) findViewById(R.id.celText);
        mOutputTextView = (TextView) findViewById(R.id.outputText);
        mConvertButton = (Button) findViewById(R.id.calcButton);

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            String currentFah;
            String convertedTemp;
            String currentCel;

            @Override
            public void onClick(View view) {

                if (!mFah.getText().toString().equals("")) {
                    currentFah = mFah.getText().toString();
                    float fahValue = Float.parseFloat(currentFah);

                    fahValue = fahValue - 32;
                    fahValue = fahValue / 9;
                    fahValue = fahValue * 5;

                    convertedTemp = String.valueOf(fahValue);

                    mOutputTextView.setText(currentFah + " degrees Farenheit is " + convertedTemp + " degrees Celsius.");
                    mFah.setText("");

                   // mCel.setText(convertedTemp);
                } else if (!mCel.getText().toString().equals("")) {
                    currentCel = mCel.getText().toString();
                    float celValue = Float.parseFloat(currentCel);


                    celValue = celValue * 9;
                    celValue = celValue / 5;
                    celValue = celValue + 32;

                    convertedTemp = String.valueOf(celValue);

                    mOutputTextView.setText(currentCel + " degrees Celsius is " + convertedTemp + " degrees Farenheit.");
                    mCel.setText("");

                   // mFah.setText(convertedTemp);
                }

            }
        });


        mFah.getText();
        mCel.getText();

        float fah = 86;
        System.out.println(fah + " degrees Fahrenheit is ...");
        // To convert Fahrenheit to Celsius
        //begin by subtracting 32
        fah = fah - 32;
        // Divide the answer by 9
        fah = fah / 9;
        // Multiply that by 5
        fah = fah * 5;
        System.out.println(fah + " degrees Celsius\n");

        float cel = 33;
        System.out.println(cel + " degrees Celsius is ...");
        // To convert Celsius to Fahrenheit
        // Multiply the answer by 9
        cel *= 9;
        // Divide by 5
        cel /= 5;
        // Add 32
        cel = cel + 32;
        System.out.println(cel + " degrees Fahrenheit");


    }
}

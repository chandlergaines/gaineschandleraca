package com.chandler.android.aca.wordnumber;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mInput;
    TextView mOutput;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInput = (EditText)findViewById(R.id.inputText);
        mOutput = (TextView)findViewById(R.id.outputText);
        mButton = (Button)findViewById(R.id.convertButton);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                char char1 = mInput.getText().toString().toLowerCase().charAt(0);
                char char2 = mInput.getText().toString().toLowerCase().charAt(1);
                long output = 0;

                String wordOutput;

                switch(char1){
                    case 'o': //one
                        output = 1;
                        break;

                    case 't': //two, three, ten
                        if (char2 == 'w'){
                            output = 2;}
                        else if (char2 == 'h'){
                            output = 3;}
                        else if (char2 == 'e'){
                            output = 10;}

                        break;

                    case 'f': //four, five
                        if (char2 == 'o'){
                            output = 4;}
                        else if (char2 == 'i'){
                            output = 5;}

                        break;

                    case 's': // six, seven
                        if (char2 == 'i'){
                            output = 6;}
                        else if (char2 == 'e'){
                            output = 7;}

                        break;

                    case 'e': //eight
                        output = 8;
                        break;

                    case 'n': //nine
                        output = 9;
                        break;
                    default:
                        mOutput.setText("Try again, buddy...");

               }
                wordOutput = String.valueOf(output);
                mOutput.setText("The number is: " + wordOutput);
            }
        });

    }
}

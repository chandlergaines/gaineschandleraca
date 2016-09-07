package com.chandler.android.aca.codekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    TextView mOutput; //initialize member variables
    EditText mInput;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*

        You hadn't commented these out on your own.

        String[] userStrings = {"omega", "beta", "omicron"}; //create a string array with codes in it
        CodeKeeper keeper = new CodeKeeper(userStrings); //creates an object of the class
        */
        mOutput = (TextView)findViewById(R.id.output); //tell member variables who they are
        mInput = (EditText)findViewById(R.id.input);
        mButton = (Button)findViewById(R.id.button);

        final String[] userStrings = new String[10];

        mButton.setOnClickListener(new View.OnClickListener(){ //set onclick
            String codeIn;

            @Override
            public void onClick(View view) {
                if (mInput.getText().toString() != ""){
                    codeIn = mInput.getText().toString();
                    userStrings[0] = codeIn;
                    mOutput.setMovementMethod(new ScrollingMovementMethod());
                    mOutput.setText("");
                }

                CodeKeeper keeper = new CodeKeeper(userStrings);
            }
        });
    }

    //new instance class
    public class CodeKeeper {
        ArrayList list; //made array list
        String[] codes = {"alpha", "lambda", "gamma", "delta", "zeta"}; //string array of codes

        public CodeKeeper(String[] userCodes){
            list = new ArrayList();
            //load built-in codes
            for (int i = 0; i < codes.length; i++){
                addCode(codes[i]); //adds code in i slot of string array list
            }

            //load user codes
            for (int j = 0; j < userCodes.length; j++){
                addCode(userCodes[j]);
            }

            //display all the codes
            // display all the codes
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                String output = (String) iterator.next(); //You needed a String called output to send to your TextView
                System.out.println(output);
                if (output != null) {
                    mOutput.append(output + "\n");
                }
            }
        }

        private void addCode(String code){ //add the code if the list does not already contain it
            if (!list.contains(code)){ //pass in the code we were looping through in the array list, if it isn't in there it adds
                list.add(code);
            }
        }
    }













}

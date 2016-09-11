package com.chandler.android.aca.comicbooks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // set member variables
    TextView mOutput;
    EditText mTitleInput;
    EditText mIssueInput;
    EditText mConditionInput;
    EditText mPriceInput;
    Button mSubmit;



    final HashMap quality = new HashMap();

    Comic[] comix = new Comic[100]; //Set up a comic array that will hold three comics


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOutput = (TextView) findViewById(R.id.output);
        mTitleInput = (EditText) findViewById(R.id.titleInput);
        mIssueInput = (EditText) findViewById(R.id.issueInput);
        mConditionInput = (EditText) findViewById(R.id.conditionInput);
        mPriceInput = (EditText) findViewById(R.id.priceInput);
        mSubmit = (Button) findViewById(R.id.button);

        //final String[] userStrings = new String[100]; --decided I didn't need an array to hold arrays..

        //setup A hashmap

        float price1 = 3.00F;
        quality.put("mint", price1);

        float price2 = 2.00F;
        quality.put("near mint", price2);

        float price3 = 1.50F;
        quality.put("very fine", price3);

        float price4 = 1.00F;
        quality.put("fine", price4);

        float price5 = 0.50F;
        quality.put("good", price5);

        float price6 = 0.25F;
        quality.put("poor", price6);

        //set up a collection
        //set up an array based on our comic class
        final Comic[] comix = new Comic[4];
        //add comics to the collection
        comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
        comix[0].setPrice((Float) quality.get(comix[0].condition));
        //in the zero slot, set method, pass in condition of very fine = 3
        comix[1] = new Comic("The Incredible Hulk", "181", "near mint", 680.00F);
        comix[1].setPrice((Float) quality.get(comix[1].condition));

        comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
        comix[2].setPrice((Float) quality.get(comix[2].condition));




        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title; //this is what holds the value we want to print
                String issue;
                String condition;
                float price;
                float basePrice;

                title = mTitleInput.getText().toString();
                issue = mIssueInput.getText().toString();
                condition = mConditionInput.getText().toString();
                basePrice = Float.parseFloat(mPriceInput.getText().toString());
             //   price;

                comix[3] = new Comic(title, issue, condition, basePrice);
                comix[3].setPrice((Float) quality.get(comix[3].condition));

              /*  Comic newComic = new Comic(
                        mTitleInput.getText().toString(),
                        mIssueInput.getText().toString(),
                        mConditionInput.getText().toString(),
                        Float.parseFloat(mPriceInput.getText().toString()));
              */

                for (int i = 0; i < comix.length; i++){
                    System.out.println("Title: " + comix[i].title);
                    System.out.println("Issue: " + comix[i].issueNumber);
                    System.out.println("Condition: " + comix[i].condition);
                    System.out.println("Price: $" + comix[i].price);

                  //  comix[i] = new Comic(title, issue, condition, basePrice);
                  //  comix[i].setPrice((Float) quality.get(comix[i].condition));
                    mOutput.setText(" Title: " + title + "\n Issue: " + issue + "\n Condition: " + condition + "\n Price: $");
                    mOutput.append(String.valueOf(comix[3].price));
                    break;
                }

            }
        });

    }

    //need a class to store the comics and attributes, you should really make another class..
    public class Comic {
        String title; //this is what holds the value we want to print
        String issueNumber;
        String condition;
        float basePrice;
        float price;


        //make constructor
        Comic (String inTitle, String inIssueNumber, String inCondition, float inBasePrice){
            title = inTitle; //this is where the stuff we enter is held
            issueNumber = inIssueNumber;
            condition = inCondition;
            basePrice = inBasePrice;

        }

        void setPrice(float factor){
            price = basePrice * factor;
        }
    }
}

package com.chandler.android.aca.santa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SantaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_santa);
    }

    public void processClicks(View display) { //takes view object from android.view package (dialer, browser, map buttons)
        Intent action = null; //declares variable for Intent object - how one activity tells another to do something
        int id = display.getId(); //call display, view which was passed in - returns ID of button clicked, saves as int variable
        // use in switch conditional which takes action depending on which button

        switch (id) {
            case (R.id.imageButton): //dialer
                action = new Intent(Intent.ACTION_DIAL, //intent constructor takes 2 arguments - action to take, variable
                        Uri.parse("tel:877-446-6723")); //& data associated with action
                break;
            case (R.id.imageButton2): //browser
                action = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.noradsanta.org"));
                break;
            case (R.id.imageButton3): //map
                action = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q-101 Saint Nicolas Dr., North Pole, AK"));
                break;
            default:
                break;
        }
        startActivity(action);

    }
}
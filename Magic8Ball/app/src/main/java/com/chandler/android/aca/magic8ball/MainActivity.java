package com.chandler.android.aca.magic8ball;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private MagicBook mMagicBook = new MagicBook();
    private DiceFeature mDiceFeature = new DiceFeature();
    String magic;
    String diceText;
    private final static float ACC = 15; // Sensitivity to alter
    // How to differentiate on different devices???
    SensorManager mSensorManager;

    TextView mMagicTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mMagicTextView = (TextView)findViewById(R.id.magicText);

        FloatingActionButton fabMagic = (FloatingActionButton) findViewById(R.id.fabMagic);
        fabMagic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                magic = mMagicBook.getMagic();
                mMagicTextView.setText(magic);
            }
        });

        FloatingActionButton fabDice = (FloatingActionButton) findViewById(R.id.fabDice);
        fabDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                diceText = mDiceFeature.getDice();
                mMagicTextView.setText(diceText);

            }
        });

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        /*Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            diceText = mDiceFeature.getDice();
            mMagicTextView.setText(diceText);
        }
         This was removed because it provided an endless loop of numbers which was terrifying
        */

       float[] values = event.values;
        if ((Math.abs(values[0]) > ACC || Math.abs(values[1]) > ACC || Math
                .abs(values[2]) > ACC)) { // X, Y, Z axis to measure location and force on those axes
            diceText = mDiceFeature.getDice();
            mMagicTextView.setText(diceText);

            for (float i=0; i<200_000; i++) {

            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        mSensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
}

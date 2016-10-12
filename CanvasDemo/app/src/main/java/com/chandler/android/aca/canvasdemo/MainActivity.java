package com.chandler.android.aca.canvasdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get a reference to the ImageView in the layout
        ImageView ourFrame = (ImageView) findViewById(R.id.imageView);
        //Frame of the canvas

        // Create a bitmap object to use as our canvas
        Bitmap ourBitmap = Bitmap.createBitmap(750,1500, Bitmap.Config.ARGB_8888);
        //Canvas that goes in the frame

        Canvas ourCanvas = new Canvas(ourBitmap);
        //Set the canvas as a canvas

        // A paint object that does our drawing, on our canvas
        Paint paint = new Paint();

        // Set the background color
        ourCanvas.drawColor(Color.BLACK);

        // Change the color of the virtual paint brush
        paint.setColor(Color.argb(255, 255, 255, 255));

        // Draw a bunch of random points
        Random random = new Random();
        for (int i = 0; i < 15000; i ++) {
            //this is a loop that runs 600 times and generates
            //random numbers that are joined into points

            int x = random.nextInt(750);
            int y = random.nextInt(1500);

            ourCanvas.drawPoint(x, y, paint);
        }

        // Draw a line
        ourCanvas.drawLine(0, 0, 750, 1500, paint);
        // Draw from point 0,0 to 750,1500

//      Change the color of the virtual paint brush
        paint.setColor(Color.argb(255, 0, 255, 0));


//      Make the text bigger
        paint.setTextSize(120f);

//      Draw some text
        ourCanvas.drawText("Hello Canvas!", 10, 750, paint);

//      Draw a circle
        ourCanvas.drawCircle(500, 500, 100, paint);
        // (500,500)-x and y values
        // 100-radius

//      Change the color of the virtual paint brush
        paint.setColor(Color.argb(255, 0, 0, 255));

//       Draw a rectangle
        ourCanvas.drawRect(500, 10, 200, 200, paint);

//      Now put the canvas in the frame
        ourFrame.setImageBitmap(ourBitmap);
    }
}

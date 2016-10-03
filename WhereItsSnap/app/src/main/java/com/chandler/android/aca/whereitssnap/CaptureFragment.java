package com.chandler.android.aca.whereitssnap;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Bitmap is a file structure like jpeg
//Uri is the file location

public class CaptureFragment extends Fragment implements LocationListener{

    private static final int CAMERA_REQUEST = 123;
    private ImageView mImageView;

    //The filepath for the photo
    String mCurrentPhotoPath;

    //Where the captured image is stored
    private Uri mImageUri = Uri.EMPTY;

    private DataManager mDataManager;

    private Location mLocation = new Location("");
    private LocationManager mLocationManager;
    private String mProvider;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  // filename
                ".jpg",         // extension
                storageDir      // folder
        );

        // Save for use with ACTION_VIEW Intent
        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDataManager = new DataManager(getActivity()
                .getApplicationContext());
        //Initialize DataManager instance by adding this

        //Initialize mLocationManager
        mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        mProvider = mLocationManager.getBestProvider(criteria, false);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout file then get all necessary references
        View view = inflater.inflate(R.layout.fragment_capture, container, false);

        mImageView = (ImageView)view.findViewById(R.id.imageView);
        Button btnCapture = (Button)view.findViewById(R.id.btnCapture);
        Button btnSave = (Button)view.findViewById(R.id.btnSave);

        final EditText mEditTextTitle = (EditText)view.findViewById(R.id.editTextTitle);
        final EditText mEditTextTag1 = (EditText)view.findViewById(R.id.editTextTag1);
        final EditText mEditTextTag2 = (EditText)view.findViewById(R.id.editTextTag2);
        final EditText mEditTextTag3 = (EditText)view.findViewById(R.id.editTextTag3);


        //Listen for the clicks on the capture button
        btnCapture.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                File photoFile = null;
                try{
                    photoFile = createImageFile();
                } catch (IOException ex){
                    //Error occurred while creating the file
                    Log.e("error", "error creating file");
                }
                //Continue only if the file was successfully created
                if(photoFile != null){
                    mImageUri = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        // Listen for clicks on the save button
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(mImageUri != null){ //check that mImageUri is initialized
                    if(!mImageUri.equals(Uri.EMPTY)) { //check that mImageUri is not empty
                        // We have a photo to save

                        Photo photo = new Photo();
                        photo.setTitle(mEditTextTitle.getText().toString()); //Store the user's title
                        photo.setStorageLocation(mImageUri); //Store the URI

                        //Set the current GPS location
                        photo.setGpsLocation(mLocation);

                        // What is in the tags
                        //Capture the user's tags with getters
                        String tag1 = mEditTextTag1.getText().toString();
                        String tag2 = mEditTextTag2.getText().toString();
                        String tag3 = mEditTextTag3.getText().toString();

                        // Assign the strings to the Photo object
                        //Store the user's tags with setters
                        photo.setTag1(tag1);
                        photo.setTag2(tag2);
                        photo.setTag3(tag3);

                        //We can combine the getter and setter calls into:
                        //photo.setTag1(mEditTextTag1.getText().toString());
                        //And you really should once you know what the hell you're doing

                        // Send the new object to our DataManager
                        mDataManager.addPhoto(photo);
                        Toast.makeText(getActivity(), "Saved", Toast.LENGTH_LONG).show();
                    }else {
                        // No image
                        Toast.makeText(getActivity(), "No image to save", Toast.LENGTH_LONG).show();
                    }
                }else {
                    // Uri not initialized
                    Log.e("Error ", "uri is null");
                }

            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {

            try {

                mImageView.setImageURI(Uri.parse(mImageUri.toString()));
            }catch(Exception e){
                Log.e("Error","Uri not set");
            }

        }else{
            mImageUri = Uri.EMPTY;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Make sure we don't run out of memory
        BitmapDrawable bd = (BitmapDrawable) mImageView.getDrawable();
        bd.getBitmap().recycle();
        mImageView.setImageBitmap(null);
    }

    @Override
    public void onLocationChanged(Location location) {
        //Update the location if it changed
        mLocation = location;

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    //Start updates when app starts/resumes
    @Override
    public void onResume() {
        super.onResume();

        mLocationManager.requestLocationUpdates(mProvider, 500, 1, this);
        //500 milliseconds(??) between updates, one meter minimum to update
    }

    @Override
    public void onPause() {
        super.onPause();

        mLocationManager.removeUpdates(this);
    }
}

package com.chandler.android.aca.whereitssnap;


import android.app.Activity;
import android.app.ListFragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class TitlesFragment extends ListFragment {

    private Cursor mCursor;
    private ActivityComs mActivityComs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the String to represent the tag to search for
        String tag = getArguments().getString("Tag");

        /*
        If TitlesFragment receives a tag to search for, it will
        only show the photo titles with that matching tag, but
        if it receives no tag, it will show all the titles. With
        this in mind, the if block either loads the Cursor object
        up with data using getTitles or getTitlesWithTag.
         */

        // Get an instance of DataManager
        DataManager d = new DataManager(getActivity().getApplicationContext());


        if(tag == "_NO_TAG"){
            // Get all the titles from the database
            mCursor = d.getTitles();
        }else{
            // Get all the titles with a specific related tag
            mCursor = d.getTitlesWithTag(tag);
        }


        // Create a new adapter
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_1, mCursor,
                //list_item_1 created by default
                new String[] { DataManager.TABLE_ROW_TITLE },
                new int[] { android.R.id.text1 }, 0 );

        // Attach the adapter to the ListView
        setListAdapter(cursorAdapter);
    }

    public void onListItemClick(ListView l, View v, int position, long id) {

        // Move the cursor to the clicked item in the list
        mCursor.moveToPosition(position);

        // What is the database _id of this item?
        int dBID = mCursor.getInt(
                mCursor.getColumnIndex(
                        DataManager.TABLE_ROW_ID));

        // Use the interface to send the clicked _id
        mActivityComs.onTitlesListItemSelected(dBID);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivityComs = (ActivityComs)activity;
        //We initialize it when it is attached
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityComs = null;
        //Set to null upon destroy
    }

}


package com.chandler.android.aca.dualfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ActivityComs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dualfragment);

        //Get a fragment manager
        FragmentManager fManager = getFragmentManager();

        //Create a new fragment using the manager
        //Passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.listFragmentHolder);

        //Check that the fragment has not already been initialized
        if(frag == null){
            frag = new AddressListFragment();
            fManager.beginTransaction()
                    .add(R.id.listFragmentHolder, frag)
                    .commit();
        }
    }

    public void onListItemSelected(int position){

        //Is there a layout with an id that matches the detail container?
        if(findViewById(R.id.detailFragmentHolder) == null){
            //If not we need to start a new activity

            Intent i = new Intent(this, PortraitDetailActivity.class);

            //We can't pass an object to an intent
            //Neither do we want to
            //So we pass its position in the array list
            i.putExtra("Position", position);
            startActivity(i);
        }else{
            //Fragment already exists

            FragmentManager fManager = getFragmentManager();
            FragmentTransaction fTransaction = fManager.beginTransaction();
            Fragment fragOld = fManager.findFragmentById(R.id.detailFragmentHolder);
            Fragment fragNew = AddressDetailFragment.newInstance(position);

            if(fragOld != null){
                fTransaction.remove(fragOld);
            }

            fTransaction.add(R.id.detailFragmentHolder, fragNew);
            fTransaction.commit();
        }

    }
}

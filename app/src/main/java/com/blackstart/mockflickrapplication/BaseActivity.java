package com.blackstart.mockflickrapplication;

import android.util.Log;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    static final String QUERY = "Query";
    static final String PHOTO_TRANSFER = "PHOTO_TRANSFER";

    void activateToolBar(boolean enableHome){
        Log.d(TAG, "activateToolBar: starts");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar == null){
            androidx.appcompat.widget.Toolbar toolbar = (
                    androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);

            if(toolbar != null){
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();
            }
        }

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(enableHome);
        }

    }

}

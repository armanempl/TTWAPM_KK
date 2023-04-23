package com.example.orientacja01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String tag = "znacznik";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "Wywołano metodę onCreate()");
    }
    @Override
    public void onConfigurationChanged (Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        Log.d(tag, "Wywołano metodę onConfigurationChanged()");
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Log.d(tag, "Orientacja pionowa");
        }
        else
        {
            Log.d(tag, "Orientacja pozioma");
        }
    }
}
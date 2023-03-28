package com.example.aktywnosci1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.util.Log;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.aktywnosci1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    String tag = "zdarzenia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "onCreate");
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(tag, "onStart()");
    }
    @Override
    public void onRestart()
    {
        super.onRestart();
        Log.d(tag, "onRestart()");
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Log.d(tag, "onResume()");
    }
    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(tag, "onPause()");
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log.d(tag, "onStop()");
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(tag, "onDestroy()");
    }
}
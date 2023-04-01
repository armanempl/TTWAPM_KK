package com.example.fragmenty02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT)
        {
            fragmentTransaction.replace(R.id.linlay, new Fragment01());
        }
        else
        {
            fragmentTransaction.replace(R.id.linlay, new Fragment02());
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    }

package com.example.animacja02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        String name = view.getTag().toString();
        int id = getResources().getIdentifier(name, "anim",
                getPackageName());
        Animation animation = AnimationUtils.loadAnimation(this, id);
        view.startAnimation(animation);
    }
}
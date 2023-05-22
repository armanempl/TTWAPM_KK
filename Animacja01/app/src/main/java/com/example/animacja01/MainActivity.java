package com.example.animacja01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.animacja);
        animationDrawable =
                (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }
    public void Start(View view){
        animationDrawable.start();
    }
    public void Stop(View view){
        animationDrawable.stop();
    }
}
package com.example.ratingbar01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtRating = (TextView) findViewById(R.id.txtRating);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRating.setText(Float.toString(ratingBar.getRating()));
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                txtRating.setText(Float.toString(rating));
            }
        });
    }
    public void onClick(View v) {
        Toast.makeText(this, Float.toString(ratingBar.getRating()),
                Toast.LENGTH_SHORT).show();
    }
}
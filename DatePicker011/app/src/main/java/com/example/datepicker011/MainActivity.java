package com.example.datepicker011;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
    }
    public void onClick(View view){
        int godzina = 0;
        int minuta = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            godzina = timePicker.getHour();
            minuta = timePicker.getMinute();

            if (godzina < 10 && minuta < 10) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("Wybrano czas: 0" + godzina + ":0" + minuta);
            } else if (godzina < 10) {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("Wybrano czas: 0" + godzina + ":" + minuta);
            }
            else if (minuta < 10){
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("Wybrano czas: " + godzina + ":0" + minuta);
            } else {
                TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("Wybrano czas " + godzina + ":" + minuta);
            }
        }

    }
}
package com.example.timepicker01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    String[] DniTygodnia = {"nd", "pn", "wt", "śr", "cz", "pt", "so"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view){
        DatePicker datePicker =
                (DatePicker)findViewById(R.id.datePicker);
        int dzien = datePicker.getDayOfMonth();
        int miesiac = datePicker.getMonth();
        int rok = datePicker.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(rok, miesiac, dzien);
        int dt = calendar.get(Calendar.DAY_OF_WEEK);
        String data = String.format("Wybrano datę %s, %s.%s.%s",
                DniTygodnia[dt - 1], dzien, miesiac + 1, rok);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(data);
    }
}
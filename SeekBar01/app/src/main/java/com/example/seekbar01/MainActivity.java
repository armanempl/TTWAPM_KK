package com.example.seekbar01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Wybrana wartość: " + seekBar.getProgress() + "/" +
                seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int postep = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                postep = progresValue;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getBaseContext(), "Wykryto ustawianie kontrolki SeekBar", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Wybrano wartość " + postep + "/" +seekBar.getMax());
                Toast.makeText(getBaseContext(),"Zakończono ustawianie kontrolki SeekBar",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
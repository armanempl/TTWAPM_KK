package com.example.projekt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button2 = (Button) findViewById(R.id.button7);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        button3 = (Button) findViewById(R.id.button8);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Zad2.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, Zadanie2_1.class);
        startActivity(intent);
    }
    public void openActivity4() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}
package com.example.stanaktywnosci01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int klik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClicked(View view){
        ++klik;
        TextView textView = (TextView)findViewById(R.id.text_view);
        textView.setText(String.format("Przycisk wciśnięto %s razy",
                klik));
        EditText editText = (EditText)findViewById(R.id.edit_text);
        editText.setText(String.format("Przycisk wciśnięto %s razy",
                klik));
    }
}

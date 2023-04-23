package com.example.stanaktywnosci02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView buttonClickCounterTextView;
    private EditText buttonClickCounterEditText;

    private static final String KEY_CLICK_COUNT = "click_count";
    private int clickCount = 0;

    private static final String TEXT_FORMAT = "Przycisk wciśnięto %d razy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClickCounterTextView = findViewById(R.id.text_view);
        buttonClickCounterEditText = findViewById(R.id.edit_text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_CLICK_COUNT, clickCount);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clickCount = savedInstanceState.getInt(KEY_CLICK_COUNT);
        updateClickCountViews();
    }

    public void onButtonClicked(View view){
        ++clickCount;
        updateClickCountViews();
    }

    private void updateClickCountViews() {
        buttonClickCounterTextView.setText(String.format(TEXT_FORMAT, clickCount));
        buttonClickCounterEditText.setText(String.format(TEXT_FORMAT, clickCount));
    }
}

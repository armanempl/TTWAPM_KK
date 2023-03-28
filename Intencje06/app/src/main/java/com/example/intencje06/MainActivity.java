package com.example.intencje06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButtonStronaWWW(View view)
    {
        EditText editText = (EditText)findViewById(R.id.editTextStronaWWW);
        String adres = editText.getText().toString();
        Uri uri = Uri.parse("http://" + adres);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickButtonMiasto(View view)
    {
        EditText editText = (EditText)findViewById(R.id.editTextMiasto);
        String miasto = editText.getText().toString();
        Uri geoUri = Uri.parse("geo:0,0?q=" + miasto);
        Intent intent = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(intent);
    }

    public void onClickButtonLokalizacja(View view)
    {
        EditText editText =
                (EditText)findViewById(R.id.editTextSzerokosc);
        String szerokosc = editText.getText().toString();
        EditText editText2 =
                (EditText)findViewById(R.id.editTextDlugosc);
        String dlugosc = editText2.getText().toString();
        String s = String.format("geo:%s,%s", szerokosc, dlugosc);
        Uri geoUri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW, geoUri);
        startActivity(intent);
    }
}
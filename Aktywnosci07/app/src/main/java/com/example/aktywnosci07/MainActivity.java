package com.example.aktywnosci07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mapa1 (View view) {
        String geoCode = "geo:41.5020952,-81.6789717&z=16";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
        startActivity(intent);
    }

    public void mapa2 (View view) {
        String code = "geo:saddr=9.938083,-84.054430&"+" daddr=9.926392,-84.055964";
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(code));
        startActivity(intent);

    }

    public void mapa3 (View view) {

        String geoCode ="google.streetview:" +"cbll=41.5020952,-81.6789717&"
                +"cbp=1,270,,45,1&mz=7";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoCode));
        startActivity(intent);
    }

    public void musicplayer (View view) {
        Intent myActivity2 = new Intent("android.intent.action.MUSIC_PLAYER");
        startActivity(myActivity2);

    }

    public void email (View view) {
        String emailSubject = "Bajo jajo";
        String emailText = "Dzień dobry, dzisiaj mamy spotkanie"
                + "on Tue. at 9:00am @ roomBU344";
        String[] emailReceiverList= {"armanempl@gmail.com"};
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("vnd.android.cursor.dir/email");
        intent.putExtra(Intent.EXTRA_EMAIL, emailReceiverList);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT,emailText);
        startActivity(Intent.createChooser(intent,"To complete action choose:"));

    }
}
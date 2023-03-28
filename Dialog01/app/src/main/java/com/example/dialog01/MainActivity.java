package com.example.dialog01;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OknoDialogowe(View view) {
        final ProgressDialog dialog = ProgressDialog.show(this,
                "Realizuję zadanie", "Proszę czekać...");
        new Thread(new Runnable(){
            public void run(){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        }).start();
    }
}

package com.example.dialog02;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OknoDialogowe(View v) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setTitle("Pobieram dane...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {
                        Toast.makeText(getBaseContext(),"Kliknięto OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Anuluj",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which)
                    {
                        Toast.makeText(getBaseContext(),
                                "Kliknięto Anuluj",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        progressDialog.show();
        new Thread(new Runnable(){
            public void run(){
                for (int i=1; i<=10; i++) {
                    try {
                        Thread.sleep(1500);
                        progressDialog.incrementProgressBy(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();
            }
        }).start();
    }
}
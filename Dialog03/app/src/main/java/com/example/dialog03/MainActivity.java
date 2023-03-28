package com.example.dialog03;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OknoDialogowe(View v) {
        AlertDialog.Builder dialogBuilder = new
                AlertDialog.Builder(this);
        dialogBuilder.setTitle("Informacja");
        dialogBuilder.setMessage("Witamy w aplikacji");
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}
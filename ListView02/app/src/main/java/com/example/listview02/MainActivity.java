package com.example.listview02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] wojewodztwa;
    ListView listView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wojewodztwa = getResources().getStringArray(R.array.wojewodztwa);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, wojewodztwa);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(adapter);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wybranePozycje = "Wybrano następujące pozycje: \n";
                for (int i=0; i<listView.getCount(); i++) {
                    if (listView.isItemChecked(i)) {
                        wybranePozycje += listView.getItemAtPosition(i) + "\n";
                    }
                }
                Toast.makeText(getApplicationContext(), wybranePozycje, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

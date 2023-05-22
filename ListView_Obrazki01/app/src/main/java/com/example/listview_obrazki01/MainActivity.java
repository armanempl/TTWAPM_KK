package com.example.listview_obrazki01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int[] obrazki = new int[8];
    String[] opisy ={
            "FB",
            "Insta1",
            "Insta2",
            "Insta3",
            "Insta4",
            "Insta5",
            "Insta6",
            "Insta"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int j = 0; j < obrazki.length; j++) {
            obrazki[j] = getResources()
                    .getIdentifier("r"+j, "drawable", getPackageName());
        }
        ListView listView = (ListView) findViewById(R.id.listView);
        MyListAdapter adapter = new MyListAdapter(this, obrazki, opisy);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    public void onItemClick(AdapterView parent,
                                            View v, int position,
                                            long id)
                    {
                        Toast.makeText(getBaseContext(),
                                "Wybrano obrazek nr " + (position + 1),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

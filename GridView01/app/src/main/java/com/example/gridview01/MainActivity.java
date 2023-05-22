package com.example.gridview01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] obrazki = new Integer[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int j = 0; j < obrazki.length; j++) {
            obrazki[j] = getResources().getIdentifier("r" + j, "drawable", getPackageName());
        }

        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter());
        gridView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView parent,
                                            View v, int position, long id) {

                        Toast.makeText(getBaseContext(),
                                "Wybrano obrazek nr " + (position + 1),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public class ImageAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return obrazki.length;
        }
        @Override
        public Object getItem(int position) {
            return obrazki[position];
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView,
                            ViewGroup parent)
        {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(getBaseContext());
                imageView.setLayoutParams(new
                        GridView.LayoutParams(500, 500));
                imageView.setScaleType(
                        ImageView.ScaleType.CENTER_INSIDE);
                imageView.setPadding(10, 10, 10, 10);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(obrazki[position]);
            return imageView;
        }
    }
}
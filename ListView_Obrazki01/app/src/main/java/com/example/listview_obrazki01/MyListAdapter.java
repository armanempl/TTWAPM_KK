package com.example.listview_obrazki01;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListAdapter extends ArrayAdapter {
    Activity activity;
    int[] obrazki;
    String[] opisy;
    public MyListAdapter(Activity a, int[] ob, String[] op) {
        super(a, R.layout.moja_lista, op);
        activity = a;
        obrazki = ob;
        opisy = op;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowView;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            rowView = inflater.inflate(R.layout.moja_lista,parent, false);
        }
        else
            rowView = convertView;
        ImageView imageView =
                (ImageView) rowView.findViewById(R.id.imageView);
        TextView textView1 =
                (TextView) rowView.findViewById(R.id.textView1);
        TextView textView2 =
                (TextView) rowView.findViewById(R.id.textView2);
        imageView.setImageResource(obrazki[position]);
        textView1.setText(opisy[position]);
        textView2.setText("To jest " + opisy[position]);
        return rowView;
    };
}

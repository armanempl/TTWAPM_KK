package com.example.horizontalscrollview01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout)
                findViewById(R.id.linearLayout);
        imageView = (ImageView) findViewById(R.id.imageView);
        for (int i = 0; i < 8; i++) {
            ImageView localView = new ImageView(this);
            localView.setLayoutParams(
                    new ViewGroup.LayoutParams(400, 400));
            localView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int resId = getResources().getIdentifier("r" + i, "drawable",
                    getPackageName());
            localView.setImageResource(resId);
            localView.setOnClickListener(this);
            linearLayout.addView(localView);
        }
        if(savedInstanceState!=null){
            Bitmap bitmap = savedInstanceState.getParcelable("obrazek");
            imageView.setImageBitmap(bitmap);
        }
    }
    public void onClick(View view) {
        ImageView localView = (ImageView)view;
        imageView.setImageDrawable(localView.getDrawable());
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        BitmapDrawable bitmapDrawable =
                ((BitmapDrawable)imageView.getDrawable());
        if (bitmapDrawable != null)
            outState.putParcelable("obrazek",
                    bitmapDrawable.getBitmap());
    }
}

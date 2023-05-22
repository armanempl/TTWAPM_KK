package com.example.imageswitcher01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    ImageSwitcher imageSwitcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout =
                (LinearLayout) findViewById(R.id.linearLayout);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        imageSwitcher.setFactory(new MyViewFactory(this));
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right));
        for (int i = 0; i < 7; i++) {
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
    }
    public void onClick(View view) {
        ImageView localView = (ImageView)view;
        imageSwitcher.setImageDrawable(localView.getDrawable());
    }
}
class MyViewFactory implements ViewSwitcher.ViewFactory {
    Context context;
    public MyViewFactory(Context c){
        context = c;
    }
    @Override
    public View makeView() {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new
                FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        return imageView;
    }
}


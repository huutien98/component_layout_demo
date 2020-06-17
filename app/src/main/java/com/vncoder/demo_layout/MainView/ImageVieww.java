package com.vncoder.demo_layout.MainView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vncoder.demo_layout.R;

public class ImageVieww extends AppCompatActivity {

    android.widget.ImageView imageView;
    TextView textView;

    android.widget.ImageView image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        image2 = findViewById(R.id.image2);
        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.textview);


        findViewById(R.id.btn_center).setOnClickListener(clickListener);
        findViewById(R.id.btn_centerCrop).setOnClickListener(clickListener);
        findViewById(R.id.btn_centerInside).setOnClickListener(clickListener);
        findViewById(R.id.btn_fitCenter).setOnClickListener(clickListener);
        findViewById(R.id.btn_fitEnd).setOnClickListener(clickListener);
        findViewById(R.id.btn_fitStart).setOnClickListener(clickListener);
        findViewById(R.id.btn_fitXY).setOnClickListener(clickListener);

        image2.setScaleType(android.widget.ImageView.ScaleType.CENTER);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Drawable img;
        img = AppCompatResources.getDrawable(getBaseContext(),R.drawable.yasuo);
        image2.setImageDrawable(img);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            android.widget.ImageView.ScaleType scaletype = android.widget.ImageView.ScaleType.CENTER;
            switch (view.getId()) {
                case R.id.btn_center:
                    scaletype = android.widget.ImageView.ScaleType.CENTER;
                    break;
                case R.id.btn_centerCrop:
                    scaletype = android.widget.ImageView.ScaleType.CENTER_CROP;
                    break;
                case R.id.btn_centerInside:
                    scaletype = android.widget.ImageView.ScaleType.CENTER_INSIDE;
                    break;
                case R.id.btn_fitCenter:
                    scaletype = android.widget.ImageView.ScaleType.FIT_CENTER;
                    break;
                case R.id.btn_fitEnd:
                    scaletype = android.widget.ImageView.ScaleType.FIT_END;
                    break;
                case R.id.btn_fitStart:
                    scaletype = android.widget.ImageView.ScaleType.FIT_START;
                    break;
                case R.id.btn_fitXY:
                    scaletype = android.widget.ImageView.ScaleType.FIT_XY;
                    break;

            }
            imageView.setScaleType(scaletype);
            textView.setText(((Button)view).getText());
        }

    };

}
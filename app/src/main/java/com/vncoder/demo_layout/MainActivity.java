package com.vncoder.demo_layout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.vncoder.demo_layout.MainView.CheckBoxx;
import com.vncoder.demo_layout.MainView.Chipp;
import com.vncoder.demo_layout.MainView.RadioGroup;
import com.vncoder.demo_layout.MainView.Snackbarrr;
import com.vncoder.demo_layout.MainView.editText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "tag" ;
     Button btn_centre1;
     Button btn_centre2;
     Button btn_helloword;
     Button button_01;
     Button button_02;
     Button radio;
     Button another;
     Button btn_placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");

        btn_placeholder = findViewById(R.id.btn_placeholder);
        btn_centre1 = (android.widget.Button) findViewById(R.id.btn_centre1);
        btn_centre2 = (android.widget.Button) findViewById(R.id.btn_centre2);
        btn_helloword = (android.widget.Button) findViewById(R.id.btn_helloword);
        button_01 = (android.widget.Button) findViewById(R.id.button_01);
        button_02 = (android.widget.Button) findViewById(R.id.button_02);
        another = findViewById(R.id.another);
        another.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainItem.class);
                startActivity(intent);
            }
        });

        btn_placeholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,constraintlatout_4.class);
                startActivity(intent);
            }
        });



        radio = findViewById(R.id.radio);

        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RadioGroup.class);
                startActivity(intent);
            }
        });



        btn_centre1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Button 1",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, CheckBoxx.class);
                startActivity(intent);
            }
        });

        btn_centre2.setOnClickListener(this);
        btn_helloword.setOnClickListener(this);
        button_01.setOnClickListener(this);
        button_02.setOnClickListener(this);
        button_01.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FancyToast.makeText(getApplication(),"longggg",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
                return false;
            }
        });
    }
    public void buttonCentre3(View view) {
        Toast.makeText(getApplicationContext(),"button 3",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, editText.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_centre2:
                ClickButton1();
                break;
            case R.id.btn_helloword:
                ClickButton2();
                break;
            case R.id.button_01:
                button_01();
                break;
            case R.id.button_02:
                button_02();
                break;
        }
    }

    private void button_01() {
        FancyToast.makeText(getApplication(),"Button1",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
        boolean e = button_02.isEnabled();
        button_02.setEnabled(!e);
    }

    private void button_02() {
        FancyToast.makeText(getApplication(),"Button2",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
        Intent intent = new Intent(MainActivity.this,ConstraintActivity.class);
        startActivity(intent);
    }



    private void ClickButton2() {
        Intent intent = new Intent(MainActivity.this, Snackbarrr.class);
        startActivity(intent);
    }
    private void ClickButton1() {
        Toast.makeText(getApplication(),"Button 2",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, Chipp.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: ");
        super.onBackPressed();
    }

    @Override
    protected void onPostResume() {
        Log.d(TAG, "onPostResume: ");
        super.onPostResume();
    }

    @Override
    public void onLowMemory() {
        Log.d(TAG, "onLowMemory: ");
        super.onLowMemory();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
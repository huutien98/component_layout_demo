package com.vncoder.demo_layout.MainView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.vncoder.demo_layout.R;


public class Snackbarrr extends AppCompatActivity implements View.OnClickListener {
    ConstraintLayout main_contain;
    Button button1;
    Button button2;
    Button button3;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbar_main2);

        main_contain = findViewById(R.id.main_contain);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        next = findViewById(R.id.next);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        next.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                SnackbarBasic();
                break;
            case R.id.button2:
                SnackbarWithCallback();
                break;
            case R.id.button3:
                CustomSnackbar();
                break;
            case R.id.next:
                next();
                break;
        }
    }

    private void next() {
        Intent intent = new Intent(Snackbarrr.this, TextVieww.class);
        startActivity(intent);
    }

    private void SnackbarBasic() {
        FancyToast.makeText(this,"snackbar",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
        com.google.android.material.snackbar.Snackbar snackbar = com.google.android.material.snackbar.Snackbar.make(main_contain,"notification from snackbar basic with love", com.google.android.material.snackbar.Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    private void SnackbarWithCallback() {
        FancyToast.makeText(this,"snackbar with love",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
        com.google.android.material.snackbar.Snackbar snackbar1 = com.google.android.material.snackbar.Snackbar
                .make(main_contain,"no internet access", com.google.android.material.snackbar.Snackbar.LENGTH_LONG)
                .setAction("again", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("this is cú lừa");
                    }
                });
        snackbar1.show();
    }

    private void CustomSnackbar() {
        FancyToast.makeText(this,"CustomSnackbar again",FancyToast.LENGTH_LONG,FancyToast.CONFUSING,true).show();
        com.google.android.material.snackbar.Snackbar snackbar3 = com.google.android.material.snackbar.Snackbar.make(main_contain,"No Internet Acess", com.google.android.material.snackbar.Snackbar.LENGTH_LONG)
                .setAction("again", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplication(),"this is cú lừa",Toast.LENGTH_LONG).show();
                    }
                });

        snackbar3.setActionTextColor(Color.RED);

        View sbView = snackbar3.getView();
        sbView.setBackgroundColor(Color.YELLOW);
        android.widget.TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        Toast.makeText(getApplication(),"button3",Toast.LENGTH_LONG).show();
        textView.setTextColor(Color.BLUE);
        snackbar3.show();
    }
}

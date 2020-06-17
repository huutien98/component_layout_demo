package com.vncoder.demo_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;

public class constraintlatout_4 extends AppCompatActivity {
    ConstraintLayout layout;
    Placeholder placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraintlatout_4);
        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);

    }

    public void swapView(View view) {
        TransitionManager.beginDelayedTransition(layout);
        placeholder.setContentId(view.getId());


    }
}
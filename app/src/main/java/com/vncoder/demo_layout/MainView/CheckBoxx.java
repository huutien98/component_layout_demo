package com.vncoder.demo_layout.MainView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.shashank.sony.fancytoastlib.FancyToast;
import com.vncoder.demo_layout.R;

public class CheckBoxx extends AppCompatActivity {
    android.widget.CheckBox answer1;
    android.widget.CheckBox answer2;
    android.widget.CheckBox answer3;
    android.widget.CheckBox answerall;
    Button btntest;
    Button hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox);
        init();

    }

    private void init() {
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        answerall = findViewById(R.id.answerall);
        attachListener();
        btntest = findViewById(R.id.btntest);
        hint = findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detachListener();
                answer2.setChecked(false);
                answer3.setChecked(false);
                answerall.setChecked(false);
                attachListener();
                answer1.setChecked(true);
            }
        });

        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kq = "";
                if (!answer2.isChecked()&&!answer3.isChecked()&&!answerall.isChecked()){
                    kq = "10đ về chỗ";
                    FancyToast.makeText(getBaseContext(),kq,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                }else {
                    kq = "chúc bạn may mắn lần sau";
                    FancyToast.makeText(getBaseContext(),kq,FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                }
            }
        });
    }

    void attachListener(){
        answer1.setOnCheckedChangeListener(listener);
        answer2.setOnCheckedChangeListener(listener);
        answer3.setOnCheckedChangeListener(listener);
        answerall.setOnCheckedChangeListener(listener);
    }

    void detachListener(){
        answer1.setOnCheckedChangeListener(null);
        answer2.setOnCheckedChangeListener(null);
        answer3.setOnCheckedChangeListener(null);
        answerall.setOnCheckedChangeListener(null);
    }

    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (buttonView == answerall){
                detachListener();
                answer1.setEnabled(!isChecked);
                answer2.setEnabled(!isChecked);
                answer3.setEnabled(!isChecked);

                answer1.setChecked(isChecked);
                answer2.setChecked(isChecked);
                answer3.setChecked(isChecked);
                attachListener();
            }else {
                FancyToast.makeText(getApplication(),buttonView.getText()+" | "+buttonView.isChecked()
                        ,FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
            }
        }
    };
}
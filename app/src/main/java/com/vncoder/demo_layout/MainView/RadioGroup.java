package com.vncoder.demo_layout.MainView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.vncoder.demo_layout.R;

public class RadioGroup extends AppCompatActivity  {
    RadioButton radio_a;
    RadioButton radio_b;
    RadioButton radio_c;
    Button test;
    TextView mgs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_group);
        radio_a = findViewById(R.id.radio_a);
        radio_b = findViewById(R.id.radio_b);
        radio_c = findViewById(R.id.radio_c);
        test = findViewById(R.id.test);
        mgs = findViewById(R.id.mgs);

        radio_a.setOnCheckedChangeListener(Listen);
        radio_b.setOnCheckedChangeListener(Listen);
        radio_c.setOnCheckedChangeListener(Listen);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_b.isChecked()){
                    mgs.setText("10đ về chỗ");
                }else {
                    mgs.setText("chúc e may mắn lần sau");
                }
            }
        });
    }

    CompoundButton.OnCheckedChangeListener Listen  = new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        test.setEnabled(true);
        if (isChecked){
            mgs.setText("bạn chọn" + buttonView.getText());
        }
    }
};


}
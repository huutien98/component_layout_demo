package com.vncoder.demo_layout.MainView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.vncoder.demo_layout.R;

public class editText extends AppCompatActivity {
    TextView tv1;
    EditText edt1;
    TextInputLayout layout,layout_password;
    TextInputEditText username;
    TextInputEditText password;
    AutoCompleteTextView tv_name;
    private static final String[] STRINGS = new String[]
            {"Điện thoại XY","Máy tính AZ","Iphone", "Tai nghe", "Loa","abc_xyz","01","02","03","monstar lab","lifetime"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext);
        tv1 = findViewById(R.id.tv1);
        edt1 = findViewById(R.id.edt1);

        layout_password = findViewById(R.id.layout_password);
        layout = findViewById(R.id.layout);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        tv_name = findViewById(R.id.tv_name);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,STRINGS);
        tv_name.setAdapter(adapter);











        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() ==0) {
                    username.setError("username is not null");
                } else {
                    username.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() ==0) {
                    password.setError("Password is not null");
                } else {
                    password.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });















        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv1.setText(edt1.getText().toString());
            }
        });
    }
}
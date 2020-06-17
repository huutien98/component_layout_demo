package com.vncoder.demo_layout.MainView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.shashank.sony.fancytoastlib.FancyToast;
import com.vncoder.demo_layout.R;


public class Chipp extends AppCompatActivity {
    EditText editText_keyword;
    Button button_add;
    ChipGroup chipGroup;
    Button button_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chip);
        editText_keyword = findViewById(R.id.editText_keyword);
        button_add = findViewById(R.id.button_add);
        chipGroup = findViewById(R.id.chipGroup);
        button_show = findViewById(R.id.button_show);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewChip();
            }
        });
        button_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelected();
            }
        });

    }
    private void addNewChip() {
        String keyWord = editText_keyword.getText().toString();
        if (keyWord == null || keyWord.isEmpty()){
            FancyToast.makeText(getApplication(),"no messenger",FancyToast.ERROR,FancyToast.LENGTH_LONG,true).show();
            return;
        }try {
            LayoutInflater inflater = LayoutInflater.from(this);
            final com.google.android.material.chip.Chip newchip = (com.google.android.material.chip.Chip) inflater.inflate(R.layout.layout_chip_entry, this.chipGroup, false);
            newchip.setText(keyWord);

            this.chipGroup.addView(newchip);
            newchip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                handleChipCloseIconClicked((com.google.android.material.chip.Chip)buttonView,isChecked);
                }
            });
            newchip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handleChipCloseIconClicked((com.google.android.material.chip.Chip) v);
                }
            });

            this.editText_keyword.setText("");
        }catch (Exception e){
            e.printStackTrace();
            FancyToast.makeText(getBaseContext(),"ERROR" +e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();

        }
    }

    private void showSelected() {
        int count = this.chipGroup.getChildCount();

        String s = null;
        for (int i=0;i<count;i++){
            com.google.android.material.chip.Chip child = (com.google.android.material.chip.Chip) chipGroup.getChildAt(i);

            if (!child.isChecked()){
                continue;
            }
            if (s == null){
                s = child.getText().toString();
            }else {
                s +="," + child.getText().toString();
            }
        }
        FancyToast.makeText(getBaseContext(),s,FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();


    }
    private void handleChipCloseIconClicked(com.google.android.material.chip.Chip chip) {
        ChipGroup parent = (ChipGroup) chip.getParent();
        parent.removeView(chip);
    }
    private void handleChipCloseIconClicked(com.google.android.material.chip.Chip chip, boolean isChecked) {
    }


}
package com.example.anti2110.materialdesign.selectionControls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.anti2110.materialdesign.R;

public class SelectionControlsActivity extends AppCompatActivity {

    private SwitchCompat switchCompat;
    private AppCompatCheckBox appCompatCheckBox;
    private AppCompatRadioButton appCompatRadioButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_controls);

        switchCompat = findViewById(R.id.switch_id);
        appCompatCheckBox = findViewById(R.id.checkbox_id);
        // appCompatRadioButton = findViewById(R.id.radioButton1_id);
        radioGroup = findViewById(R.id.radioGroup_id);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(SelectionControlsActivity.this, "Switch is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SelectionControlsActivity.this, "Switch is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(SelectionControlsActivity.this, "CheckBox is checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SelectionControlsActivity.this, "CheckBox is not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        appCompatRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked) {
//                    Toast.makeText(SelectionControlsActivity.this, "RadioButton is checked", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(SelectionControlsActivity.this, "RadioButton is not checked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1_id:
                        Toast.makeText(SelectionControlsActivity.this, "RadioButton1 is checked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2_id:
                        Toast.makeText(SelectionControlsActivity.this, "RadioButton2 is checked", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}

package com.example.anti2110.materialdesign.testField;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.anti2110.materialdesign.R;

public class TextFieldActivity extends AppCompatActivity {

    private AppCompatEditText user;
    private AppCompatEditText pass;
    private RelativeLayout relativeLayout;
    private TextInputLayout userLayout;
    private TextInputLayout passLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_field);

        user = findViewById(R.id.username_textField);
        userLayout = findViewById(R.id.username_textInputLayout);
        pass = findViewById(R.id.password_textField);
        passLayout = findViewById(R.id.password_textInputLayout);
        relativeLayout = findViewById(R.id.relLayout);

        relativeLayout.setOnClickListener(null);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(user.getText().toString().isEmpty()) {
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please enter your username");
                } else {
                    userLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(user.getText().toString().isEmpty()) {
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please enter your username");
                } else {
                    userLayout.setErrorEnabled(false);
                }
            }
        });

        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);

    }
}

package com.example.anti2110.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.anti2110.materialdesign.navigationDraw.NavigationDrawActivity;
import com.example.anti2110.materialdesign.testField.TextFieldActivity;
import com.example.anti2110.materialdesign.toolbar.ToolbarActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_toolbar).setOnClickListener(this);
        findViewById(R.id.btn_navigation_draw).setOnClickListener(this);
        findViewById(R.id.btn_text_field).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_toolbar:
                intent = new Intent(MainActivity.this, ToolbarActivity.class);
                break;
            case R.id.btn_navigation_draw:
                intent = new Intent(MainActivity.this, NavigationDrawActivity.class);
                break;
            case R.id.btn_text_field:
                intent = new Intent(MainActivity.this, TextFieldActivity.class);
                break;
        }
        startActivity(intent);
    }

}

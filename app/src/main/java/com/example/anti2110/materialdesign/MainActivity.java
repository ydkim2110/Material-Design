package com.example.anti2110.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.anti2110.materialdesign.collapsingToolbar.CollapsingToolbarActivity;
import com.example.anti2110.materialdesign.navigationDraw.NavigationDrawActivity;
import com.example.anti2110.materialdesign.pickers.DatePickerActivity;
import com.example.anti2110.materialdesign.pickers.TimePickerActivity;
import com.example.anti2110.materialdesign.selectionControls.SelectionControlsActivity;
import com.example.anti2110.materialdesign.swipeRefreshLayout.SwipeRefreshActivity;
import com.example.anti2110.materialdesign.testField.TextFieldActivity;
import com.example.anti2110.materialdesign.toolbar.ToolbarActivity;
import com.example.anti2110.materialdesign.viewPager_ImageSlide.ViewPagerImageSlideActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_toolbar).setOnClickListener(this);
        findViewById(R.id.btn_navigation_draw).setOnClickListener(this);
        findViewById(R.id.btn_text_field).setOnClickListener(this);
        findViewById(R.id.btn_collapsing_toolbar).setOnClickListener(this);
        findViewById(R.id.btn_swipe_refresh).setOnClickListener(this);
        findViewById(R.id.btn_time_picker).setOnClickListener(this);
        findViewById(R.id.btn_date_picker).setOnClickListener(this);
        findViewById(R.id.btn_viewPager_imageSlide).setOnClickListener(this);
        findViewById(R.id.btn_selection_controls).setOnClickListener(this);

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
            case R.id.btn_collapsing_toolbar:
                intent = new Intent(MainActivity.this, CollapsingToolbarActivity.class);
                break;
            case R.id.btn_swipe_refresh:
                intent = new Intent(MainActivity.this, SwipeRefreshActivity.class);
                break;
            case R.id.btn_time_picker:
                intent = new Intent(MainActivity.this, TimePickerActivity.class);
                break;
            case R.id.btn_date_picker:
                intent = new Intent(MainActivity.this, DatePickerActivity.class);
                break;
            case R.id.btn_viewPager_imageSlide:
                intent = new Intent(MainActivity.this, ViewPagerImageSlideActivity.class);
                break;
            case R.id.btn_selection_controls:
                intent = new Intent(MainActivity.this, SelectionControlsActivity.class);
                break;
        }
        startActivity(intent);
    }

}

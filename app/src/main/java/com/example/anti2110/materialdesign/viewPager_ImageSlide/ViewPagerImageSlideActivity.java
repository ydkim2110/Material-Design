package com.example.anti2110.materialdesign.viewPager_ImageSlide;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.anti2110.materialdesign.R;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class ViewPagerImageSlideActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private SlideShowAdapter adapter;
    private CircleIndicator indicator;
    private Handler handler;
    private Runnable runnable;
    private Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_image_slide);

        toolbar = findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager_id);
        indicator = findViewById(R.id.circleIndicator_id);

        adapter = new SlideShowAdapter(this);

        viewPager.setAdapter(adapter);

        indicator.setViewPager(viewPager);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                int i = viewPager.getCurrentItem();

                if(i==adapter.images.length-1) {
                    i=0;
                    viewPager.setCurrentItem(i, true);
                } else {
                    i++;
                    viewPager.setCurrentItem(i, true);
                }
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 2000, 2000);


    }
}

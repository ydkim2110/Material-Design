package com.example.anti2110.materialdesign.viewPager_ImageSlide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.anti2110.materialdesign.R;

public class SlideShowAdapter extends PagerAdapter {

    private Context context;
    LayoutInflater inflater;

    public int[] images = {
            R.drawable.angrybirds,
            R.drawable.cuttherope,
            R.drawable.worms3,
            R.drawable.clashofclans,
            R.drawable.pou,
            R.drawable.fruitninja,
            R.drawable.wheresmywhater
    };

    public SlideShowAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View view = inflater.inflate(R.layout.slideshow_layout, container, false);

        ImageView img = view.findViewById(R.id.imageView_id);

        // img.setImageResource(images[position]);
        Glide.with(context).load(images[position]).into(img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "Image" + (position + 1), Snackbar.LENGTH_LONG).show();
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);

    }
}

package com.dev.tt;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.dev.tt.R;

public class ImageAdapter extends PagerAdapter {

    private Context mcontext;
    private int[] mImageIds = new int[] {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

    ImageAdapter(Context context){

        mcontext = context;
    }



    @Override
    public int getCount() {
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageView = new ImageView(mcontext);

        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setImageResource(mImageIds[position]);

        container.addView(imageView, 0);
        return imageView;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ImageView)object);
    }
}

package com.example.agrostore01.CapaPresentacion.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.agrostore01.R;

public class ImagenAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImagesIds = new int[] {R.drawable.promo, R.drawable.promo2, R.drawable.promo3};

    public ImagenAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImagesIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(mImagesIds[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}

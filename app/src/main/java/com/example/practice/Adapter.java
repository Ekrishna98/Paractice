package com.example.practice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class Adapter extends BaseAdapter {
    private Context mContext;
    
    public Adapter(Context c){

        mContext = c;
    }
    
    @Override
    public int getCount() {

        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {

        return null;
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType((ImageView.ScaleType.CENTER_CROP));
            imageView.setPadding(8,8, 8, 8);

        }
        else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    public Integer[] mThumbIds = {
            R.drawable.sample, R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5

    };
}

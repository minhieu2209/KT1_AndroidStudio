package com.example.donate.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.donate.R;

public class SpinnerAdapter extends BaseAdapter {
    private int[] img = {R.drawable.img_1, R.drawable.img_2,
            R.drawable.img_3, R.drawable.img_4, R.drawable.img_5, R.drawable.img_6};
    private Context context;

    public SpinnerAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int i) {
        return img[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_img, viewGroup, false);
        ImageView imageView = item.findViewById(R.id.item_img);
        imageView.setImageResource(img[i]);
        return item;
    }
}

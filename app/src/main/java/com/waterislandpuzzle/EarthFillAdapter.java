package com.waterislandpuzzle;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by gaurav.saki on 11/10/2016.
 */
public class EarthFillAdapter extends BaseAdapter {
    private Context mContext;
    public EarthFillAdapter(Context c) {
        mContext = (Context) c;

    }

    public int getCount() {
        return Utils.getEarthHashMap().size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    private int getValueFromIndex(int pos){
        return  (new ArrayList<Integer>(Utils.getEarthHashMap().values())).get(pos);

    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(131, 131));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
           // imageView.setPadding(8, 8, 8, 8);

        } else {
            imageView = (ImageView) convertView;
        }

       imageView.setBackgroundColor( ContextCompat.getColor(mContext, getValueFromIndex(position)));
        return imageView;
    }



}

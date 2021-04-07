package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerCustomAdapter extends BaseAdapter {
    private SpinnerActivity context;
    private String[] countryNames;
    private int[] flag;
    public SpinnerCustomAdapter(SpinnerActivity context, String[] countryNames,int[] flag) {
        this.context = context;
        this.countryNames = countryNames;
        this.flag = flag;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return countryNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spinner_view,parent,false);
        }
        ImageView img = convertView.findViewById(R.id.imageViewSId);
        TextView textCountry = convertView.findViewById(R.id.countryViewId);
        TextView descriptionText = convertView.findViewById(R.id.descriptionId);

        img.setImageResource(flag[position]);
        textCountry.setText(countryNames[position]);

        return convertView;
    }
}

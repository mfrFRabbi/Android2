package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private String[] countryNames,temCountry;
    private int[] flag,temFlag;
    private LayoutInflater inflater;
    private Filter sc;

    public CustomAdapter(Context context, String[] countryNames, int[] flag) {
        this.context = context;
        this.countryNames = countryNames;
        this.flag = flag;
        temCountry = countryNames;
        temFlag = flag;
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

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_view, parent, false);
        }

            ImageView imageView = convertView.findViewById(R.id.imageViewId);
            TextView textView = convertView.findViewById(R.id.countryTextId);
            imageView.setImageResource(flag[position]);
            textView.setText(countryNames[position]);
        return convertView;
    }

    public Filter getFilter(){
        if(sc == null){
            sc = new Search();
        }
        return sc;
    }

    
    private class Search extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            
            if(constraint!= null && constraint.length()>0) {
                constraint = constraint.toString().toLowerCase();
                String[] filter = new String[temCountry.length];
                int[] filterFlag = new int[flag.length];
                for (int i = 0; i < temCountry.length; i++) {
                    if (temCountry[i].toLowerCase().contains(constraint)) {
                        filter[i] = temCountry[i];
                        filterFlag[i] = temFlag[i];
                    }
                }
                results.count =filter.length;
                results.values = filter;
            }else {
                results.count = temCountry.length;
                results.values = temCountry;
            }


            
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                countryNames = (String[]) results.values;
                notifyDataSetChanged();
        }
    }
}
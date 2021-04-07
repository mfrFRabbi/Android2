package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<CountryInfo> list,list2;
    private Filter obj;

    public CustomAdapter(Context context, List<CountryInfo> list) {
        this.context = context;
        this.list = list;
        list2 = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position).getCountryNames();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_view,parent,false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageViewId);
        TextView textView = convertView.findViewById(R.id.textViewId);

        imageView.setImageResource(list.get(position).flag);
        textView.setText(list.get(position).countryNames);

        return convertView;
    }

    public Filter getFilter(){
        if(obj == null){
            obj = new SearchFilter();
        }
        return obj;
    }

    private class SearchFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint.length() > 0 && constraint != null){
                constraint.toString().toLowerCase();
                List<CountryInfo> temList = new ArrayList<>();
                for(int i = 0; i<list2.size();i++){
                    if(list2.get(i).getCountryNames().toLowerCase().contains(constraint)){
                        temList.add(new CountryInfo(list2.get(i).countryNames,list2.get(i).flag));
                    }
                }
                results.count = temList.size();
                results.values = temList;
            }else {
                results.count = list2.size();
                results.values = list2;
            }


            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (List<CountryInfo>) results.values;
                notifyDataSetChanged();
        }
    }
}

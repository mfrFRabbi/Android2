package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> headerList,copyHeaderList;
    private HashMap<String,List<String> > childString;
    private Filter filterObj;

    public ExpandableAdapter(Context context, List<String> headerList, HashMap<String, List<String>> childString) {
        this.context = context;
        this.headerList = headerList;
        copyHeaderList = headerList;
        this.childString = childString;
    }

    @Override
    public int getGroupCount() {
        return headerList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childString.get(headerList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return headerList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childString.get(headerList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerText = getGroup(groupPosition).toString();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group_layout,null);
        }
        TextView  textView =  convertView.findViewById(R.id.headerTextViewId);
        textView.setText(headerText);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = getChild(groupPosition,childPosition).toString();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout,null);
        }
        TextView  textView =  convertView.findViewById(R.id.childTextViewId);
        textView.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public Filter getFilter(){
        if(filterObj == null){
            filterObj = new SearchFilter();
        }
        return filterObj;
    }

    private class SearchFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if(constraint != null && constraint.length()>0){
                constraint.toString().toLowerCase();
                List<String> filterList = new ArrayList<>();
                for(int i = 0; i<copyHeaderList.size();i++){
                    if(copyHeaderList.get(i).toLowerCase().contains(constraint)){
                        filterList.add(copyHeaderList.get(i));
                    }
                }

                filterResults.count = filterList.size();
                filterResults.values = filterList;

            }else {
                filterResults.count = copyHeaderList.size();
                filterResults.values = copyHeaderList;
            }


            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                headerList = (List<String>) results.values;
                notifyDataSetChanged();
        }
    }
}

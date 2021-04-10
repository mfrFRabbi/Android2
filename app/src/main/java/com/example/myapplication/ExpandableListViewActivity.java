package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ExpandableListViewActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private List<String> headerList;
    private HashMap<String,List<String> > childString;
    private ExpandableAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        expandableListView = findViewById(R.id.expandId);
        prepareList();
        adapter = new ExpandableAdapter(this,headerList,childString);
        expandableListView.setAdapter(adapter);


    }

    private void prepareList(){
        String[] headerStrings = getResources().getStringArray(R.array.computer_Abbreviation);
        String[] childStrings = getResources().getStringArray(R.array.fullFormOfComputerAbbreviation);
        headerList = new ArrayList<>();
        childString = new HashMap<>();

        for(int i =0;i<headerStrings.length;i++){
            headerList.add(headerStrings[i]);
            List<String> child = new ArrayList<>();
            child.add(childStrings[i]);
            childString.put(headerList.get(i),child);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_bar_layout, menu);
        MenuItem menuItem = menu.findItem(R.id.searchId);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
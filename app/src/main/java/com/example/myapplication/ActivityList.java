package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.Arrays;

public class ActivityList extends AppCompatActivity implements AdapterView.OnItemClickListener {
private ListView listView;
private String[] countryName;
private CustomAdapter adapter;
private SearchView searchView;
private int[] img ={R.drawable.afg,R.drawable.australia,R.drawable.bhutan,
        R.drawable.bd,R.drawable.china,R.drawable.germany,
        R.drawable.india,R.drawable.iran,R.drawable.iraq,
        R.drawable.japan,R.drawable.malaysia,R.drawable.nepal,
        R.drawable.pak,R.drawable.saudiarabia};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        this.setTitle("Country Name");

        listView = findViewById(R.id.listViewId);

        countryName = getResources().getStringArray(R.array.countryName);
        Arrays.sort(countryName);
        Arrays.sort(img);

        searchView = findViewById(R.id.search_barId);


        adapter = new CustomAdapter(this,countryName,img);
        listView.setAdapter(adapter);

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

        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String value = (String) adapter.getItem(position);
        Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_bar_layout,menu);
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
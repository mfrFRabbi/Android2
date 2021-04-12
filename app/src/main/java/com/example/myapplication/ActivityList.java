package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ActivityList extends AppCompatActivity {
    private GridView gridView;
    private String[] countryName;
    private CustomAdapter adapter;
    private SearchView searchView;
    private List<CountryInfo> list;
    private int[] img = {R.drawable.afg, R.drawable.australia, R.drawable.bhutan,
            R.drawable.bd, R.drawable.china, R.drawable.germany,
            R.drawable.india, R.drawable.iran, R.drawable.iraq,
            R.drawable.japan, R.drawable.malaysia, R.drawable.nepal,
            R.drawable.pak, R.drawable.saudiarabia};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        this.setTitle("Country Name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        gridView = findViewById(R.id.gridViewId);
        countryName = getResources().getStringArray(R.array.countryName);
        Arrays.sort(countryName);
        Arrays.sort(img);
        list = new ArrayList<>();


        for (int i = 0; i < countryName.length; i++) {
            list.add(new CountryInfo(countryName[i], img[i]));
        }

        adapter = new CustomAdapter(this, list);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String v = adapter.getItem(position).toString();
                Toast.makeText(getApplicationContext(), v, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_bar_layout, menu);
        MenuItem item = menu.findItem(R.id.searchId);
        SearchView searchView = (SearchView) item.getActionView();

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId() == android.R.id.home){
           this.finish();
       }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class ActivityList extends AppCompatActivity {
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listViewId);

        final String[] countryName = getResources().getStringArray(R.array.countryName);
        Arrays.sort(countryName);

        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<>(getBaseContext(),
                R.layout.list_view,
                R.id.textViewId,
                countryName);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryName[position]+ position;
                Toast.makeText(getBaseContext(),value,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class AutoCompleteText extends AppCompatActivity {
private AutoCompleteTextView autoCompleteText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher_background);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        autoCompleteText = findViewById(R.id.autoCompleteTextId);
        String[] countryNames = getResources().getStringArray(R.array.countryName);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,countryNames);
        autoCompleteText.setThreshold(1);
        autoCompleteText.setAdapter(adapter);

        autoCompleteText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),autoCompleteText.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
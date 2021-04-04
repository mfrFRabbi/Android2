package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnID);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent;
               intent = new Intent(getApplicationContext(),ActivityList.class);
               startActivity(intent);
            }
        });


    }
}
package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.settingId) {
            Toast.makeText(this,"Setting Menu",Toast.LENGTH_SHORT).show();
         //   return true;
        }

        if(item.getItemId() == R.id.shareId) {
            Toast.makeText(this,"Share Menu",Toast.LENGTH_SHORT).show();
          //  return true;
        }
        if(item.getItemId() == R.id.feedbackId) {
            Toast.makeText(this,"FeedBack Menu",Toast.LENGTH_SHORT).show();
          //  return true;
        }
        if(item.getItemId() == R.id.aboutId) {
            Toast.makeText(this,"About Menu",Toast.LENGTH_SHORT).show();
          //  return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
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

private Button button,spinnerBtn,progressBtn,autoBtn,expandableBtn,fragmentBtn;
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

        spinnerBtn = findViewById(R.id.spinnerBtnId);
        spinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),SpinnerActivity.class);
                startActivity(intent);
            }
        });

        progressBtn = findViewById(R.id.progressBtnId);
        progressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),ProgressActivity.class);
                startActivity(intent);
            }
        });

        autoBtn = findViewById(R.id.autoBtnId);
        autoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),AutoCompleteText.class);
                startActivity(intent);
            }
        });

        expandableBtn = findViewById(R.id.expandableListBtnId);
        expandableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),ExpandableListViewActivity.class);
                startActivity(intent);
            }
        });

        fragmentBtn = findViewById(R.id.fragmentBtnId);
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(),FragmentDemo.class);
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
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String sub = "This Subject";
            String body = "This is Body field";
            intent.putExtra(Intent.EXTRA_SUBJECT,sub);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"Share With"));
          //  return true;
        }
        if(item.getItemId() == R.id.feedbackId) {
            Toast.makeText(this,"FeedBack Menu",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getBaseContext(),FeedBackActivity.class);
            startActivity(intent);

          //  return true;
        }
        if(item.getItemId() == R.id.aboutId) {
            Toast.makeText(this,"About Menu",Toast.LENGTH_SHORT).show();
          //  return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
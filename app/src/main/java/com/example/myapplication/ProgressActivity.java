package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {
private ProgressBar progressBar;
 int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove title bar
        /* requestWindowFeature(Window.FEATURE_NO_TITLE);
         getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
         getSupportActionBar().hide();
          setTitle("Progress Bar");
         */
        setContentView(R.layout.activity_progress);


        progressBar = findViewById(R.id.progressBarId);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(progress = 20;progress <= 100;progress = progress + 20){
                    try {
                        Thread.sleep(1000);
                        progressBar.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();

    }
}
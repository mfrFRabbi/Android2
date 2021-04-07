package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner spinner;
    private Button printBtn;
    private TextView textView;
    private String[] countryNames;
    private int[] flag = {R.drawable.afg, R.drawable.australia, R.drawable.bhutan,
            R.drawable.bd, R.drawable.china, R.drawable.germany,
            R.drawable.india, R.drawable.iran, R.drawable.iraq,
            R.drawable.japan, R.drawable.malaysia, R.drawable.nepal,
            R.drawable.pak, R.drawable.saudiarabia};
    SpinnerCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = findViewById(R.id.spinnerId);
        printBtn = findViewById(R.id.printId);
        textView = findViewById(R.id.textId);

        countryNames = getResources().getStringArray(R.array.countryName);
        Arrays.sort(countryNames);
        Arrays.sort(flag);
        adapter = new SpinnerCustomAdapter(this,countryNames,flag);

        spinner.setAdapter(adapter);
        printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(spinner.getSelectedItem().toString());
            }
        });
    }
}
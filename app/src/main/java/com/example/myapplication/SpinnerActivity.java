package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerActivity extends AppCompatActivity {
private Spinner spinner;
private Button printBtn;
private TextView textView;
private String[] countryNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = findViewById(R.id.spinnerId);
        printBtn = findViewById(R.id.printId);
        textView = findViewById(R.id.textId);

        countryNames = getResources().getStringArray(R.array.countryName);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this,R.layout.spinner_view,R.id.text_ViewId,countryNames);
        spinner.setAdapter(adapter);
        printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(spinner.getSelectedItem().toString());
            }
        });
    }
}
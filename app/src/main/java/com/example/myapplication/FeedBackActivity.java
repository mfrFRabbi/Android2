package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedBackActivity extends AppCompatActivity {

    private EditText name,email,feedBack;
    private Button submitBtn,clearBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        name = findViewById(R.id.nameEditTextId);
        email = findViewById(R.id.emailEditTextId);
        feedBack = findViewById(R.id.feedbackEditTextId);
        submitBtn = findViewById(R.id.submitBtnId);
        clearBtn = findViewById(R.id.clearBtnId);

            clearBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name.setText("");
                    feedBack.setText("");
                    email.setText("");
                }
            });

            submitBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/email");
                        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{
                                "mdfazlerabbi.diu@gmail.com"
                        });
                        intent.putExtra(Intent.EXTRA_SUBJECT,"feedback form");
                        intent.putExtra(Intent.EXTRA_TEXT,"Name: "+name.getText().toString()+"\n"+"Email:"
                                +email.getText().toString()+"\n"+"FeedBack: "+feedBack.getText().toString());

                        startActivity(Intent.createChooser(intent,"Share With Email"));

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });


    }
}
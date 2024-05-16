package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class verbal_topics extends AppCompatActivity {

    CardView syllogism;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal_topics);
        syllogism=findViewById(R.id.syllogism);
        syllogism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(verbal_topics.this,verbal_dashboard.class);
                    startActivity(i);
                }
            }
        });

    }
}
package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class logical_topics extends AppCompatActivity {

    CardView number_series;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical_topics);
        number_series=findViewById(R.id.number_series);
        number_series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(logical_topics.this, logical_dashboard.class);
                    startActivity(i);
                }
            }
        });

    }
}
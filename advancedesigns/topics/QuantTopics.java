package com.example.advancedesigns.topics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.advancedesigns.percentage_dashboard;
import com.example.advancedesigns.R;

public class QuantTopics extends AppCompatActivity {

    CardView btnPercentage = null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quant_topics);

        btnPercentage = findViewById(R.id.btnPercentage);

        btnPercentage.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), percentage_dashboard.class);
            startActivity(intent);
        });



    }


}
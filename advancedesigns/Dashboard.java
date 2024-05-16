package com.example.advancedesigns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.advancedesigns.topics.QuantTopics;

public class Dashboard extends AppCompatActivity {


    CardView Quantitative = null;
    CardView logical=null;

    CardView verbrsn=null;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        Quantitative = findViewById(R.id.BtnQuant);
        logical=findViewById(R.id.logical);
        verbrsn=findViewById(R.id.verbrsn);

        Quantitative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), QuantTopics.class);
                startActivity(intent);
            }
        });

        logical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), logical_topics.class);
                startActivity(intent);
            }
        });

        verbrsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),verbal_topics.class);
                startActivity(intent);
            }
        });

    }


}
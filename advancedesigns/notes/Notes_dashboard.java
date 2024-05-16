package com.example.advancedesigns.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.advancedesigns.R;

public class Notes_dashboard extends AppCompatActivity {
    CardView Quantitative = null;
    CardView logical = null;
    CardView verbal = null;
    CardView nonverbal = null;
    CardView verbal_ability = null;
    CardView data_interpretation = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_dashboard);


        Quantitative = findViewById(R.id.quant_btn);
        logical = findViewById(R.id.logical_btn);
        verbal = findViewById(R.id.verbal_btn);
        nonverbal = findViewById(R.id.nonverbal_btn);
        verbal_ability =findViewById(R.id.verbal_ability_btn);
        data_interpretation=findViewById(R.id.data_interpretation_btn);

        Quantitative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notes_dashboard.this, Quant_notes.class);
                startActivity(intent);
            }
        });
        logical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notes_dashboard.this, logical_notes.class);
                startActivity(intent);
            }
        });
        verbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notes_dashboard.this, verbal_notes.class);
                startActivity(intent);
            }
        });

        nonverbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notes_dashboard.this, nonverbal_notes.class);
                startActivity(intent);
            }
        });
        verbal_ability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notes_dashboard.this,Verbal_ability_notes.class);
                startActivity(intent);
            }
        });
        data_interpretation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notes_dashboard.this, data_interprtetion_notes.class);
                startActivity(intent);
            }
        });

    }
}



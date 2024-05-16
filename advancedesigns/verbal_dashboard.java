package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class verbal_dashboard extends AppCompatActivity {
    CardView practice=null;
    CardView quiz=null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical_dashboard);
        practice=findViewById(R.id.logical_practice);
        quiz=findViewById(R.id.logical_quiz);
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(verbal_dashboard.this, verbal_practice_questions.class);
                    startActivity(i);
                }
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(verbal_dashboard.this, verbal_quiz.class);
                    startActivity(i);
                }
            }
        });

    }

}
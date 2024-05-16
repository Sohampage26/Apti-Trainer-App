package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class percentage_dashboard extends AppCompatActivity {
    CardView practice=null;
    CardView quiz=null;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percentage_dashboard);
        practice=findViewById(R.id.quant_practice);
        quiz=findViewById(R.id.quant_quiz);
        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(percentage_dashboard.this, percentage_practice_questions.class);
                    startActivity(i);
                }
            }
        });
       quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(percentage_dashboard.this,QuizAcitivity.class);
                    startActivity(i);
                }
            }
        });

    }

}
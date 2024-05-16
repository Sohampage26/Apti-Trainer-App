package com.example.advancedesigns.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedesigns.R;

public class verbal_notes extends AppCompatActivity {

    private  String title="Syllogism";
    private String link="https://testzone.smartkeeda.com/Blog/Syllogism";
    private  String title1="Blood Relation Test";
    private String link1="https://examsdaily.in/wp-content/uploads/2018/09/br.pdf";
    private  String title2="Cause and Effect";
    private String link2="https://ldh.la.gov/assets/medicaid/hss/docs/NH/IHICauseEffectDiagramFishboneDirections.pdf";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal_notes);
        Button syllogism=findViewById(R.id.syllogism);
        Button blood=findViewById(R.id.blood_relation_test);
        Button cause=findViewById(R.id.cause_and_effect);
        syllogism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new DownloadTask(verbal_notes.this,link,title);
            }
        });
        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(verbal_notes.this,link1,title1);
            }
        });
        cause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(verbal_notes.this,link2,title2);
            }
        });

    }
}
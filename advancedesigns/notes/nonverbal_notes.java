package com.example.advancedesigns.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedesigns.R;

public class nonverbal_notes extends AppCompatActivity {

    private  String title="Series";
    private String link="https://www.whitman.edu/mathematics/calculus/calculus_11_Sequences_and_Series.pdf";
    private  String title1="Figure Matrix";
    private String link1="https://meritnotes.com/reasoning/reasoning-figure-matrix/1-79396/";
    private  String title2="Classification and Mirror Image";
    private String link2="https://static1.squarespace.com/static/64492636b9d871623dfb4be7/t/645c6f88957b800d16e0b920/1683779464630/99918308413.pdf";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonverbal_notes);
        Button series=findViewById(R.id.series);
        Button figure=findViewById(R.id.figure_matrix);
        Button classification=findViewById(R.id.classification);
        series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new DownloadTask(nonverbal_notes.this,link,title);
            }
        });
        figure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(nonverbal_notes.this,link1,title1);
            }
        });
        classification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(nonverbal_notes.this,link2,title2);
            }
        });

    }
}
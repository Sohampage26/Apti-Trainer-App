package com.example.advancedesigns.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedesigns.R;

public class logical_notes extends AppCompatActivity {

    private  String title="Number Series";
    private String link="https://www.bankexamstoday.com/2016/02/number-series-pdf-100-questions-with.html";
    private  String title1="Analogies";
    private String link1="https://ugcportal.com/raman-files/Analogy%20Test%20with%20Answers%20PDF.pdf";
    private  String title2="Letter and Symbol Series";
    private String link2="https://www.scribd.com/document/454952934/Logical-Reasoning-Letter-and-Symbol-Series-pdf";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logical_notes);
        Button number=findViewById(R.id.number_series);
        Button analogy=findViewById(R.id.analogy);
        Button letter=findViewById(R.id.letter);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new DownloadTask(logical_notes.this,link,title);
            }
        });
        analogy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(logical_notes.this,link1,title1);
            }
        });
        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(logical_notes.this,link2,title2);
            }
        });

    }
}
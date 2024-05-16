package com.example.advancedesigns.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedesigns.R;

public class Quant_notes extends AppCompatActivity {

    private  String title="Percentage";
    private String link="https://www.mathcentre.ac.uk/resources/uploaded/mc-ty-percent-2009-1.pdf";
    private  String title1="Profit and Loss";
    private String link1="https://wsdot.wa.gov/sites/default/files/2021-10/Profit-and-Loss-Statement-Example.pdf";
    private  String title2="Simple Interest";
    private String link2="https://examsdaily.in/wp-content/uploads/2019/01/Simple-Compound-Interest-Study-Material.pdf";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quant_notes);
       Button percent=findViewById(R.id.percentage);
        Button profit=findViewById(R.id.profit);
        Button si=findViewById(R.id.si);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(Quant_notes.this,link,title);
            }
        });
        profit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(Quant_notes.this,link1,title1);
            }
        });
        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(Quant_notes.this,link2,title2);
            }
        });

    }
}
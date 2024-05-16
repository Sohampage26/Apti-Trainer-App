package com.example.advancedesigns.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedesigns.R;

public class data_interprtetion_notes extends AppCompatActivity {

    private  String title="Table Charts";
    private String link="https://www.template.net/editable/103848/8-times-table-chart-template";
    private  String title1="Bar Charts";
    private String link1="https://www.cdc.gov/nhsn/pdfs/ps-analysis-resources/barcharts.pdf";
    private  String title2="Pie Charts";
    private String link2="https://www.nuffieldfoundation.org/sites/default/files/files/FSMQ%20Pie%20charts.pdf";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_interprtetion_notes);
        Button table=findViewById(R.id.table);
        Button bar=findViewById(R.id.bar);
        Button pie=findViewById(R.id.pie);
        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new DownloadTask(data_interprtetion_notes.this,link,title);
            }
        });
        bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(data_interprtetion_notes.this,link1,title1);
            }
        });
        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(data_interprtetion_notes.this,link2,title2);
            }
        });

    }

}
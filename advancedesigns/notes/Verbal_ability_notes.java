package com.example.advancedesigns.notes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.advancedesigns.R;

public class Verbal_ability_notes extends AppCompatActivity {

    private  String title="Synonyms and Antonyms";
    private String link="https://cdn1.byjus.com/wp-content/uploads/2020/06/Synonyms-and-Antonyms-List.pdf";
    private  String title1="Paragraph Formation";
    private String link1="https://uni-mysore.ac.in/english-version/sites/default/files/content/l4_ability_and_aptitude_part_1.pdf";
    private  String title2="Ordering of Sentences";
    private String link2="https://pdf.exampundit.in/sentence-rearrangement-questions-pdf";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbal_ability_notes);
        Button synonyms=findViewById(R.id.synonyms_antonyms);
        Button paragraph=findViewById(R.id.paragraph);
        Button order=findViewById(R.id.order);
        synonyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {new DownloadTask(Verbal_ability_notes.this,link,title);
            }
        });
        paragraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(Verbal_ability_notes.this,link1,title1);
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DownloadTask(Verbal_ability_notes.this,link2,title2);
            }
        });

    }
}
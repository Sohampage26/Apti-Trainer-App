package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView topics,notes,mocktest,mnc,discuss;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindashboard);
        topics=findViewById(R.id.topics);
        notes=findViewById(R.id.notes);
        mocktest=findViewById(R.id.mocktest);
        mnc=findViewById(R.id.compony);
        discuss=findViewById(R.id.discussion);

        topics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(MainActivity.this,Dashboard.class);
                    startActivity(i);
                }
            }
        });
        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                if(id==R.id.notes)
                {
                    Intent i=new Intent(MainActivity.this,maindashboard.class);
                    startActivity(i);
                }
            }
        });
        mocktest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=v.getId();
                if(id==R.id.discussion)
                {
                    Intent i=new Intent(MainActivity.this,maindashboard.class);
                    startActivity(i);
                }
            }
        });
    }

}
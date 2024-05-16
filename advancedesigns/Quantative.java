package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Quantative extends AppCompatActivity implements View.OnClickListener {

    CardView percentage;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantative);
       percentage=findViewById(R.id.percentage_btn);
        percentage.setOnClickListener(this);

    }
    public void onClick(View v){

        switch (v.getId()){
            case R.id.percentage_btn:
                Intent i=new Intent(Quantative.this, percentage_dashboard.class);
                startActivity(i);



        }

    }
}
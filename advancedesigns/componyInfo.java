package com.example.advancedesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class componyInfo extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compony_info);

        TextView txtview = findViewById(R.id.link1);
        txtview.setMovementMethod(LinkMovementMethod.getInstance());


        TextView txtview1 = findViewById(R.id.link2);
        txtview.setMovementMethod(LinkMovementMethod.getInstance());


    }
}
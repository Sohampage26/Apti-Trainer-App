package com.example.advancedesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Discussion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discussion);
    }

    public void Go(View view)
    {
        int id = view.getId();

        if (id == R.id.btn2)
        {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            String phoneNumber = "8432143939";
            Uri phoneNumberUri = Uri.parse("tel:" + phoneNumber);
            i.setData(phoneNumberUri);

            startActivity(i);
        }

        if (id == R.id.btn3)
        {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_SENDTO);

            String phoneNumber = "8432143939";
            Uri phoneNumberUri = Uri.parse("smsto:" + phoneNumber);
            i.setData(phoneNumberUri);
            startActivity(i);
        }

        if (id == R.id.btn4)
        {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            String phoneNumber = "8767414040";
            Uri phoneNumberUri = Uri.parse("tel:" + phoneNumber);
            i.setData(phoneNumberUri);
            startActivity(i);
        }

        if (id == R.id.btn5)
        {
            Intent i = new Intent();
            i.setAction(Intent.ACTION_SENDTO);
            String phoneNumber = "8767414040";
            Uri phoneNumberUri = Uri.parse("smsto:" + phoneNumber);
            i.setData(phoneNumberUri);
            startActivity(i);
        }
    }


}
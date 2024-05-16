package com.example.advancedesigns;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.advancedesigns.notes.Notes_dashboard;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class maindashboard extends AppCompatActivity{

    CardView topics,notes,mocktest,enterprise,discuss;
    Button logout;
    GoogleSignInClient gClient;
    GoogleSignInOptions gOptions;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindashboard);
        topics=findViewById(R.id.topics);
        notes=findViewById(R.id.notes);
        mocktest=findViewById(R.id.mocktest);
        enterprise=findViewById(R.id.compony);
        discuss=findViewById(R.id.discussion);
        logout=findViewById(R.id.logout);


        gOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gClient= GoogleSignIn.getClient(this,gOptions);

        GoogleSignInAccount gAccount=GoogleSignIn.getLastSignedInAccount(this);
        if(gAccount!=null){
            String gName=gAccount.getDisplayName();
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                        startActivity(new Intent(maindashboard.this,Dashboard.class));
                    }
                });
            }
        });


        topics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(maindashboard.this,Dashboard.class);
                    startActivity(i);
                }
            }
        });

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                    Intent i=new Intent(maindashboard.this, Notes_dashboard.class);
                    startActivity(i);
                }

        });

        mocktest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Intent i=new Intent(maindashboard.this, StartingScreenActivity.class);
                startActivity(i);
            }

        });

        enterprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(maindashboard.this, componyInfo.class);
                    startActivity(i);
                }
            }
        });

        discuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent i=new Intent(maindashboard.this, Discussion.class);
                    startActivity(i);
                }
            }
        });



    }

}
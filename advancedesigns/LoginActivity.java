package com.example.advancedesigns;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.developer.gbuttons.GoogleSignInButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseApp;

import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;
import com.developer.gbuttons.GoogleSignInButton;


public class LoginActivity extends AppCompatActivity {

    EditText mail, password;
    TextView tvSignupRedirect,fgpwd;
    Button btnLoginIN;
    FirebaseAuth firebaseAuth;

//    GoogleSignInButton googleBtn;
//    GoogleSignInOptions gOptions;
//    GoogleSignInClient gClient;


    private static final String TAG="LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Init();

        firebaseAuth = FirebaseAuth.getInstance();

       fgpwd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
               View dialogView=getLayoutInflater().inflate(R.layout.activity_forget_pass,null);
               EditText forgotMail=dialogView.findViewById(R.id.forgotmail);

               builder.setView(dialogView);
               AlertDialog dialog=builder.create();

               dialogView.findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String userEmail=forgotMail.getText().toString();

                       if(TextUtils.isEmpty(userEmail) && !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
                           Toast.makeText(LoginActivity.this, "Enter Your Registred Email Id", Toast.LENGTH_SHORT).show();
                           return;
                       }
                       firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if(task.isSuccessful()){
                                   Toast.makeText(LoginActivity.this, "Check Your Email", Toast.LENGTH_SHORT).show();
                                   dialog.dismiss();
                               }else{
                                   Toast.makeText(LoginActivity.this, "Unable To Send , Failed", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });

                   }
               });

               dialogView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       dialog.dismiss();
                   }
               });

               if(dialog.getWindow()!=null){

                   dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
               }

               dialog.show();

           }
       });






        btnLoginIN.setOnClickListener(view -> {
            if (isInfoValid(mail.getText().toString(), password.getText().toString())) {
                LoginUser(mail.getText().toString(), password.getText().toString());
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        });

        tvSignupRedirect.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
        });
    }



    private void LoginUser(String userMail, String userPass) {
        firebaseAuth.signInWithEmailAndPassword(userMail, userPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{

                            try{
                                throw task.getException();
                            } catch(FirebaseAuthInvalidUserException e){

                                mail.setError("User does not exist or no longer valid");

                            }catch(FirebaseAuthInvalidCredentialsException e){
                                mail.setError("Invalid Credentials , Kindly Check Email & Password Again");

                            }catch(Exception e){
                                Log.e(TAG,e.getMessage());
                                Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();

                            }

                        }
                    }
                });
    }

    private boolean isInfoValid(String userMail, String userPass) {

        if (userMail.isEmpty()) {
            mail.setError("Please Enter Your Email Id");
            return false;
        }
        if (userPass.isEmpty()) {
            password.setError("Please Enter Your Password");
            return false;
        }

        return true;
    }

    private void Init() {
        mail = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        tvSignupRedirect = findViewById(R.id.signupRedirect);
        btnLoginIN = findViewById(R.id.login_btn);
        fgpwd=findViewById(R.id.fgpwd);
        //googleBtn=findViewById(R.id.googleBtn);
    }

}


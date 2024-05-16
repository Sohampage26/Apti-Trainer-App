package com.example.advancedesigns;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.gbuttons.GoogleSignInButton;
import com.example.advancedesigns.Model.UserInfo;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;


import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    EditText userName, phoneNo, email, password, comPass;
    Button Register;
    TextView tvLogin;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    GoogleSignInButton googleBtn;
    GoogleSignInOptions gOptions;
    GoogleSignInClient gClient;

    private static final String TAG="SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        FirebaseApp.initializeApp(this);

        Init(); // function to get All Id's

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        Register.setOnClickListener(view -> {
            if (isInfoValid(userName.getText().toString(), phoneNo.getText().toString(), email.getText().toString(), password.getText().toString(), comPass.getText().toString())) {
                registerUser(email.getText().toString(), password.getText().toString());
            } else {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });

        tvLogin.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), LoginActivity.class)));


        gOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gClient= GoogleSignIn.getClient(this,gOptions);

        GoogleSignInAccount gAccount=GoogleSignIn.getLastSignedInAccount(this);

        if(gAccount!=null){
            finish();
            Intent intent=new Intent(SignUpActivity.this,maindashboard.class);
            startActivity(intent);
        }

        ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()== Activity.RESULT_OK){
                    Intent data=result.getData();
                    Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
                    try{
                        task.getResult(ApiException.class);
                        finish();
                        Intent intent=new Intent(SignUpActivity.this,maindashboard.class);
                        startActivity(intent);
                    }catch(ApiException e){
                        Toast.makeText(SignUpActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent=gClient.getSignInIntent();
                activityResultLauncher.launch(signInIntent);
            }
        });




    }



    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign-in success, do your desired operations here
                    } else {
                        Toast.makeText(this, "Firebase authentication failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void registerUser(String mail, String pass) {
        firebaseAuth.createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            SaveInfo(userName.getText().toString(), phoneNo.getText().toString(), email.getText().toString(), password.getText().toString());
                        }
                    }
                });

    }

    private void SaveInfo(String name, String phone, String mail, String pass) {


        UserInfo userInfo = new UserInfo(name, phone, mail, pass);

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            databaseReference.child("User").child(uid).setValue(userInfo)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            } else{

                                try{
                                    throw task.getException();
                                }catch(FirebaseAuthWeakPasswordException e){
                                    password.setError("Your Password Is Too Weak");
                                }catch(FirebaseAuthInvalidCredentialsException e){
                                    password.setError("Your Email Is Invalid");
                                }catch(FirebaseAuthUserCollisionException e){
                                    password.setError("User is already registered with this email");
                                }catch(Exception e){
                                    Log.e(TAG,e.getMessage()) ;
                                    Toast.makeText(SignUpActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        }
    }

    private boolean isInfoValid(String name, String phone, String mail, String pass, String compass) {

        String contactRegex="[6-9][0-9]{9}";
        Matcher contactMatcher;
        Pattern contactPattern=Pattern.compile(contactRegex);
        contactMatcher=contactPattern.matcher(phone);

        if (name.isEmpty()) {
            userName.setError("Please enter Username ");
            return false;
        }
        else if (phone.isEmpty()) {
            phoneNo.setError("Please Enter Contact No");
            return false;
        }

        else if(phone.length()!=10){
            phoneNo.setError("Contact No Must Be 10 digits");
            return false;

        }

        else if(!contactMatcher.find()){
            phoneNo.setError("Contact No is Not Valid");
            return false;
        }
        else if (mail.isEmpty()) {
            email.setError("Please Enter Email Address");
            return false ;
        }
        else if (pass.isEmpty()) {
            password.setError("Please Enter Password");
            return false;
        }
        else if(pass.length()<=6){
            password.setError("Passoword Length must be gretaer than 6 characters");
            return false;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Please Enter Valid Email");
            return false;
        }
        else if (compass.isEmpty()) {
            comPass.setError("Please Confirm Your Password");
            return false;
        }
        else if(!pass.equals(compass)){
            comPass.setError("Password & ConfirmPassword should match!");
            comPass.clearComposingText();
            password.clearComposingText();
            return false;
        }
        return true;
    }

    private void Init() {
        userName = findViewById(R.id.signupUsername);
        phoneNo = findViewById(R.id.signupContact);
        email = findViewById(R.id.signupEmail);
        password = findViewById(R.id.signupPassword);
        comPass = findViewById(R.id.signupConfirmPass);
        Register = findViewById(R.id.signup_btn);
        tvLogin = findViewById(R.id.loginRedirect);
        googleBtn=findViewById(R.id.googleBtn);
    }

}
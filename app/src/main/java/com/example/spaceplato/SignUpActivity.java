package com.example.spaceplato;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth fbAuth;
    EditText name,email,phone,password,cpassword;
    ProgressBar progressBar;

    Button signup;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        fbAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        cpassword = (EditText) findViewById(R.id.cpassword);
        progressBar = findViewById(R.id.progressBar);

        signup = findViewById(R.id.button_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        tv = findViewById(R.id.forgot_password);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            }
        });
    }

    private void createUser(){

        String user_name = name.getText().toString().trim();
        String user_email = email.getText().toString().trim();
        String user_phone = phone.getText().toString().trim();
        String user_password = password.getText().toString().trim();
        String user_cpassword = cpassword.getText().toString().trim();

        if(TextUtils.isEmpty(user_name)){
            name.setError("Name cannot be empty!");
            name.requestFocus();
        }else if(TextUtils.isEmpty(user_email)){
            email.setError("Email cannot be empty!");
            email.requestFocus();
        }else if(TextUtils.isEmpty(user_phone)){
            phone.setError("Date of birth cannot be empty!");
            phone.requestFocus();
        }else if(TextUtils.isEmpty(user_password)){
            password.setError("Password cannot be empty!");
            password.requestFocus();
        }else if(TextUtils.isEmpty(user_cpassword)){
            cpassword.setError("Confirm password cannot be empty!");
            cpassword.requestFocus();
        }else if(!user_password.equals(user_cpassword)) {
            cpassword.setError("Confirm password does not match!");
            cpassword.requestFocus();
        }else{
            progressBar.setVisibility(View.VISIBLE);
            fbAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().getUid())
                                .setValue(new User(user_name,user_email,user_phone,user_password));
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(SignUpActivity.this,"Registered successfully",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    }else{
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(SignUpActivity.this,"Registration error: " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}
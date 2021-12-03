package com.example.flaxen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTPVarification extends AppCompatActivity {
   private EditText otp;
   private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpvarification);
        otp= findViewById(R.id.otpedittext);
        Login = findViewById(R.id.verifyotp);
        Intent intent = getIntent();
        String data = intent.getStringExtra("Code");


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(otp.getText().toString().equals(data)){
                    Intent intent = new Intent(OTPVarification.this, LoginPage.class);

                }
                else{
                    Toast.makeText(OTPVarification.this, "Please Enter the Valid OTP", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
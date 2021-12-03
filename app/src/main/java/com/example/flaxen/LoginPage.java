package com.example.flaxen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private EditText MobileNo;
    private EditText PasswordNo;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        MobileNo = findViewById(R.id.MobileNo);
        PasswordNo = findViewById(R.id.EnterPassword);
        Intent intent = getIntent();
        String Mobile = intent.getStringExtra("Mobile");
        String Password = intent.getStringExtra("Password");
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MobileNo.getText().toString().equals(Mobile)&&PasswordNo.getText().toString().equals(Password)){
                    Intent intent = new Intent(LoginPage.this, HomePage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginPage.this, "Please Enter the Correct Mobile No. and Password", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
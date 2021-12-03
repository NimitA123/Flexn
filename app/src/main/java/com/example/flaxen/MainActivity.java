package com.example.flaxen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText Name;
    private EditText Email;
    private EditText MobileNo;
    private EditText Password;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.action_image);
        Name = findViewById(R.id.EnterName);
        Email = findViewById(R.id.EnterMobile);
        MobileNo = findViewById(R.id.EnterMobile);
        Password = findViewById(R.id.EnterPassword);
        btn = findViewById(R.id.SubmitButton);


        submit();
    }





    private void submit() {
        btn.setOnClickListener(new View.OnClickListener()

         {
            @Override
            public void onClick(View view) {

               if(!MobileNo.getText().toString().trim().isEmpty()&&MobileNo.getText().toString().trim()
               .length() == 10) { PhoneAuthProvider.getInstance().verifyPhoneNumber("+91" + MobileNo.getText().toString(), 60, TimeUnit.SECONDS,
                           MainActivity.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                               @Override
                               public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                               }

                               @Override
                               public void onVerificationFailed(@NonNull FirebaseException e) {
                                   Intent intent = new Intent(MainActivity.this,OTPVarification.class);

                                   intent.putExtra("Name", Name.getText().toString());
                                   intent.putExtra("Mobile", MobileNo.getText().toString());
                                   intent.putExtra("Email", Email.getText().toString());
                                   intent.putExtra("Password", Password.getText().toString());
                                   //  intent.putExtra("image", byteArray);
                                  // intent.putExtra("Code", s);
                                   startActivity(intent);
                                Toast.makeText(MainActivity.this, "Please Check Your Connection", Toast.LENGTH_LONG).show();
                               }

                               @Override
                               public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                   super.onCodeSent(s, forceResendingToken);
                                   Intent intent = new Intent(MainActivity.this,OTPVarification.class);

                                   intent.putExtra("Name", Name.getText().toString());
                                   intent.putExtra("Mobile", MobileNo.getText().toString());
                                   intent.putExtra("Email", Email.getText().toString());
                                   intent.putExtra("Password", Password.getText().toString());
                                 //  intent.putExtra("image", byteArray);
                                   intent.putExtra("Code", s);
                                   startActivity(intent);
                               }
                           });



               }
               else{
                   Toast.makeText(MainActivity.this, "Please Enter all the Character of the Number", Toast.LENGTH_LONG).show();
               }


            }

        });
    }

}

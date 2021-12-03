package com.example.flaxen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    private TextView Name;
    private TextView Mobile;
    private TextView Email;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Name = findViewById(R.id.Name);
        Mobile = findViewById(R.id.MobileNo);
        Email = findViewById(R.id.Email);
        imageView = findViewById(R.id.image1);
        /*byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);*/
        Intent intent = getIntent();
        String name =intent.getStringExtra("Name");
        String mobile =intent.getStringExtra("Mobile");
        String email =intent.getStringExtra("Email");
        Name.setText(name);
        Mobile.setText(mobile);
        Email.setText(email);
        //imageView.setImageBitmap(bmp);
    }
}
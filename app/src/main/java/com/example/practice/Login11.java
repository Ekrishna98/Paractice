package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Login11 extends AppCompatActivity {

    TextView email22;
    TextView pass22;
    public static String Email = "Email";
    public static  String  Pass = "Pass";

    private String email11 , pass11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login11);
        email22 = findViewById(R.id.tv4);
        pass22 = findViewById(R.id.tv5);

       Intent i= getIntent();
         email11 = i.getStringExtra(Email);
         pass11 = i.getStringExtra(Pass);
        email22.setText(email11);
        pass22.setText(pass11);

    }
}
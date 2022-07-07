package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText etmail;
    EditText etpass;
    Button log;
    private String email11 , pass11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etmail = findViewById(R.id.etEmail);
        etpass = findViewById(R.id.etPass);
        log = findViewById(R.id.login);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email11 = etmail.getText().toString();
                 pass11 = etpass.getText().toString();

                Intent i = new Intent(Login.this,Login11.class);
                i.putExtra(Login11.Email, email11);
                i.putExtra(Login11.Pass, pass11);
                startActivity(i);
            }
        });

    }
}
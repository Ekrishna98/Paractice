package com.example.practice.AlertPassword;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.Home_page;
import com.example.practice.R;

public class AlertPassword extends AppCompatActivity {

    private EditText enterpass;
    Button cancel, ok;
    TextView alertTittle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_password);
        alertTittle = findViewById(R.id.alertTitle);
    }

    public void show_Dialg(View view){

        final AlertDialog.Builder alert = new AlertDialog.Builder(AlertPassword.this);
        View mview = getLayoutInflater().inflate(R.layout.alertbox,null);

        enterpass = mview.findViewById(R.id.AlertPassword);
        cancel = mview.findViewById(R.id.Alert_Cancel);
        ok = mview.findViewById(R.id.Alert_ok);

        alert.setView(mview);

        final AlertDialog alertDialog = alert.create();
        alertDialog.setCanceledOnTouchOutside(false);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            alertDialog.dismiss();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Password = "12345";
                String PassCheck = enterpass.getText().toString();

                if (PassCheck.matches(Password)) {
                    startActivity(new Intent(AlertPassword.this, Home_page.class));
                } else {
                    Toast.makeText(AlertPassword.this, "Enter Wrong Password..", Toast.LENGTH_SHORT).show();
                }
            }

        });
        alertDialog.show();

    }
}
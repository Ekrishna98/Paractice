package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class unit_converting extends AppCompatActivity {
    EditText etNum;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converting);
        etNum = findViewById(R.id.etNum);
        tv = findViewById(R.id.tv2);
        btn = findViewById(R.id.convert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calling method
                ConvertToPounds();
            }
        });
    }
    private void ConvertToPounds() {
        // Create user input text string variable
        String Value = etNum.getText().toString();
        // Converting  String to Double
        double kilo = Double.parseDouble(Value);
        // Converting kilo to pounds formula
        double pounds = kilo * 2.205;
        // displaying result in textView
        tv.setText("" +pounds);
    }
}
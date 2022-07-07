package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Firebase extends AppCompatActivity {
    FirebaseFirestore fb;
    EditText LoginEmail1, LoginPass1;
    Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        LoginEmail1 = findViewById(R.id.etMailFire);
        LoginPass1 = findViewById(R.id.etPassFire);
        Submit = findViewById(R.id.BtnSubmit);

        fb =FirebaseFirestore.getInstance();

    Submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Map<String,String> Emp = new HashMap<>();

            Emp.put("Name","Krishna");
            Emp.put("course", "Corejava");
            fb.collection("Employee")
                    .add(Emp)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(Firebase.this, "Successful", Toast.LENGTH_SHORT).show();
                        }
                    });











//            Emp.put("email", LoginEmail1.getText().toString().trim());
//            Emp.put("Password",LoginPass1.getText().toString().trim());
//            fb.collection("Employees")
//                    .add(Emp).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                @Override
//                public void onSuccess(DocumentReference documentReference) {
//                    LoginEmail1.setText("");
//                    LoginPass1.setText("");
//                    Toast.makeText(Firebase.this, "Inserted Data Successful", Toast.LENGTH_SHORT).show();
//                }
//            });
          // Toast.makeText(Firebase.this, "Submit clicked", Toast.LENGTH_SHORT).show();
        }
    });
    }

   }



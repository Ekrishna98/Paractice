package com.example.practice.Shared_Preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practice.R;

public class Shared_Pref_main extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText email;
    EditText pass;

    private static final String myprefrences = "mypref";
    private static final String Email = "emailKey";
    private static final String Pass = "passKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_main);

        email = findViewById(R.id.etMail);
        pass = findViewById(R.id.etPass1);

        sharedPreferences = getSharedPreferences(myprefrences, Context.MODE_PRIVATE);

        //CHecking for any data stored
        if(sharedPreferences.contains(Email))
            email.setText(sharedPreferences.getString(Email,""));
        if(sharedPreferences.contains(Pass))
            pass.setText(sharedPreferences.getString(Pass,""));
        }

        // Saving Data:
    public void Save(View view){
        String e= email.getText().toString();
        String p= pass.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Email,e);
        editor.putString(Pass,p);
        editor.commit();
    }

    // Clearing Data Fields :
    public void Clear(View view){
//        email = findViewById(R.id.etMail);
//        pass = findViewById(R.id.etPass1);
        email.setText("");
        pass.setText("");
    }

    // Getting Data:
    public void Get(View view){
//        sharedPreferences = getSharedPreferences(myprefrences,Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
        }
        if(sharedPreferences.contains(Pass)){
            pass.setText(sharedPreferences.getString(Pass,""));
        }

    }

}

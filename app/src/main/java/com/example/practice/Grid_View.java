package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Grid_View extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        // Calling a gridview Adapter calss
        GridView g = findViewById(R.id.gridview);
        g.setAdapter(new Adapter(this));

        //  click item some action then use it
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Grid_View.this, "you click item : " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
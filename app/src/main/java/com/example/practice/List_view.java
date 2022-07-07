package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class List_view extends AppCompatActivity {
    // ListView variable
    ListView lv;

    // Data to be dispalyed into list
    String [] mbltypes = {
            "Redmi Note 9 pro", "Sumsung Galaxy", "vivo mobile",
            "Oppo mobile", "Nokia mobile","Redmi pro", "Tablet", "Lenovo",
            "Iphone", "Iphone 13","Iphone 13","Iphone 13","Iphone 13","Iphone 13","Iphone 13","Iphone 13",
            "Iphone 13","Iphone 13","Iphone 13","Iphone 13","Iphone 13",
            "Iphone 13","Iphone 13","Iphone 13","Iphone 13",
            "Iphone 13","Iphone 13","Iphone 13","Iphone 13",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv = findViewById(R.id.listview);

        // Array Adapter :
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mbltypes
        );
        lv.setAdapter(adapter);

        // Handling click Events in listview
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(List_view.this, "I Will Buy: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
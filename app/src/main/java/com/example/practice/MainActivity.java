package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView l = findViewById(R.id.ListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("Flipkart");
        adapter.add("Amazon");
        adapter.add("Meeshow");
        adapter.add("dangle");
        adapter.add("dog");
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterViewView,View view, int i, long l) {
    String item = (String) adapterViewView.getItemAtPosition(i);
        Toast.makeText(this, "You selected: "+item , Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this,List_view.class));

    }
}

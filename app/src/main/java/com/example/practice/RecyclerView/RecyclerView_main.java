package com.example.practice.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.practice.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerView_main extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Movie>  movieList = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);

        recyclerView = findViewById(R.id.recyclerview);
        myAdapter = new MyAdapter(movieList);

        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(myAdapter);
        insertData();
    }


    private void insertData() {
        Movie movie = new Movie(" R R R","Action", "2022");
        movieList.add(movie);

         movie = new Movie(" Pushpa","Thrilling", "2021");
        movieList.add(movie);
        myAdapter.notifyDataSetChanged();

    }
}
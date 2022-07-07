package com.example.practice.ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.practice.R;

public class ViewPager_ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

//   ViewPager2 viewPager2 = findViewById(R.id.viewpager);
//   viewPager2.setAdapter(new CustomPagerAdapter(this));

        // Intialization ViewPager
        ViewPager viewPager = findViewById(R.id.viewpager);
        // Setting the Adapter
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }

    }

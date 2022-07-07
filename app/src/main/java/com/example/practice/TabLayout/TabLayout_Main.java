package com.example.practice.TabLayout;

import static com.google.android.material.tabs.TabLayout.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.practice.R;
import com.example.practice.ViewPager.ViewPager_;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TabLayout_Main extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;
    PagerAdapter pagerAdapter;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_main);

       tabLayout = findViewById(R.id.tabBar);
        tabChats = findViewById(R.id.tabChat);
        tabStatus = findViewById(R.id.tabStatus);
         tabCalls = findViewById(R.id.tabCall);
         viewPager = findViewById(R.id.viewpager);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        // One last step is to change the tab view when the tabs is selected or clicked
        tabLayout.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
   viewPager.addOnPageChangeListener(new TabLayoutOnPageChangeListener(tabLayout));
    }
}
package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.RecyclerView.RecyclerView_main;
import com.example.practice.Shared_Preferences.Shared_Pref_main;
import com.example.practice.TabLayout.TabLayout_Main;
import com.example.practice.UserPermission.MutiUserPermission;
import com.example.practice.UserPermission.Sample;
import com.example.practice.Wifi.Wifi_On_Off;

public class Home_page extends AppCompatActivity implements View.OnClickListener{

    Button ListView, Recycler, TabView, SharedPref,WifiSwitch, Firebase, GridView, Userper, MultiUser,
    UnitConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ListView = findViewById(R.id.BtnListView);
        Recycler = findViewById(R.id.BtnRecycler);
        TabView = findViewById(R.id.BtnTabView);
        SharedPref = findViewById(R.id.BtnSharedPref);
        WifiSwitch = findViewById(R.id.BtnWifi);
        Firebase = findViewById(R.id.BtnFirebase);
        GridView = findViewById(R.id.BtnGridView);
        Userper = findViewById(R.id.BtnUserPer);
        MultiUser = findViewById(R.id.BtnMultiUser);
        UnitConvert = findViewById(R.id.BtnUnitConert);

        ListView.setOnClickListener(this);
        Recycler.setOnClickListener(this);
        TabView.setOnClickListener(this);
        SharedPref.setOnClickListener(this);
        WifiSwitch.setOnClickListener(this);
        Firebase.setOnClickListener(this);
        GridView.setOnClickListener(this);
        Userper.setOnClickListener(this);
        MultiUser.setOnClickListener(this);
        UnitConvert.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.BtnListView:
            startActivity(new Intent(Home_page.this,List_view.class));
            break;
            case R.id.BtnRecycler:
                startActivity(new Intent(Home_page.this, RecyclerView_main.class));
                break;
            case R.id.BtnTabView:
                startActivity(new Intent(Home_page.this, TabLayout_Main.class));
                break;
            case R.id.BtnSharedPref:
                startActivity(new Intent(Home_page.this, Shared_Pref_main.class));
                break;
            case R.id.BtnWifi:
                startActivity(new Intent(Home_page.this, Wifi_On_Off.class));
                break;
            case R.id.BtnFirebase:
                startActivity(new Intent(Home_page.this,Firebase.class));
                break;
            case R.id.BtnGridView:
                startActivity(new Intent(Home_page.this,Grid_View.class));
                break;
            case R.id.BtnUserPer:
                startActivity(new Intent(Home_page.this, Sample.class));
                break;
            case R.id.BtnMultiUser:
                startActivity(new Intent(Home_page.this, MutiUserPermission.class));
                break;
            case R.id.BtnUnitConert:
                startActivity(new Intent(Home_page.this, unit_converting.class));
                break;

        }

    }
}
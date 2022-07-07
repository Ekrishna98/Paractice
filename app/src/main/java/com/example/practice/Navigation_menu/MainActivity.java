package com.example.practice.Navigation_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.practice.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private Object item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.contact:
                        Toast.makeText(MainActivity.this, "contact open", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Setting:
                        Toast.makeText(MainActivity.this, "settings open", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.logout:
                        Toast.makeText(MainActivity.this, "logout account", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        return true;

                }
                return true;
            }
        });


    }
}
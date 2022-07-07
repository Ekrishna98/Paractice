package com.example.practice.Navigation_menu_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.practice.R;
import com.google.android.material.navigation.NavigationView;




// 26-06-22 to 27-06-22


public class MainActivity extends AppCompatActivity {


    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        toolbar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        nav = findViewById(R.id.navimenu);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.Setting:
                        Toast.makeText(MainActivity.this, "setting open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                        case R.id.contact:
                        Toast.makeText(MainActivity.this, "contact open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.logout:
                        Toast.makeText(MainActivity.this, "LogOut", Toast.LENGTH_SHORT).show();
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        finish();
                        break;
                }
                return true;
            }
        });


    }
}
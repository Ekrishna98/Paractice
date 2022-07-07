package com.example.practice.ContextMenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

public class ContextMenu_1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu1);
    Button btn = findViewById(R.id.tvView);
    registerForContextMenu(btn);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("choose your option");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ok:
                Toast.makeText(this, "ok clicked", Toast.LENGTH_SHORT).show();
            return true;
                case R.id.cancel:
                    finish();
               // Toast.makeText(this, "cancel clicked", Toast.LENGTH_SHORT).show();
            return true;
                default:
                return super.onContextItemSelected(item);
        }

    }
}
package com.example.practice.Wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.practice.R;

public class Wifi_On_Off extends AppCompatActivity {

    SwitchCompat wifiswitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_on_off);

        wifiswitch = findViewById(R.id.WifiSwitch);

        wifiswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wifiswitch.isChecked()){
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                }else{
                    WifiManager wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
            }
        });





    }
}
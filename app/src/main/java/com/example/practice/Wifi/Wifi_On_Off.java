package com.example.practice.Wifi;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

public class Wifi_On_Off extends AppCompatActivity {

    Button Wifi;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_on_off);

        Wifi = findViewById(R.id.btnWifi);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if(wifiManager.isWifiEnabled()){
            Wifi.setText("Turn WIFI OFF");
        }else if(!wifiManager.isWifiEnabled()){
            Wifi.setText("Turn Wifi On");
        }


        Wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(wifiManager.isWifiEnabled()){
                    Wifi.setText("Turn Wifi on");
                    wifiManager.setWifiEnabled(false);
                }else if(!wifiManager.isWifiEnabled()){
                        Wifi.setText("Turn Wifi Off");
                        wifiManager.setWifiEnabled(true);
                    }
            }
        });

    }
}
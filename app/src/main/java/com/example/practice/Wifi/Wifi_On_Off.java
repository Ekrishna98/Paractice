package com.example.practice.Wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

public class Wifi_On_Off extends AppCompatActivity {

    Switch wifiSwitch;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_on_off);

        wifiSwitch = findViewById(R.id.btnWifi);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        WifiCheckMethod();

    }
        //  wifiCheck Method Started............
        public void WifiCheckMethod() {


          wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (isChecked) {
                      wifiManager.setWifiEnabled(true);
                      wifiSwitch.setText("Turn_Wifi On");
                  } else {
                      wifiManager.setWifiEnabled(false);
                      wifiSwitch.setText("Turn_Wifi Off");
                  }
              }
          });
        }

        @Override
        protected void onStart() {
            super.onStart();
            IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
            registerReceiver(wifiStateReceiver,intentFilter);
        }

        @Override
        protected void onStop() {
            super.onStop();
            unregisterReceiver(wifiStateReceiver);
        }

        private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                        WifiManager.WIFI_STATE_UNKNOWN);
                switch (wifiStateExtra){
                    case WifiManager.WIFI_STATE_ENABLED:
                        wifiSwitch.setChecked(true);
                        wifiSwitch.setText("Turn_Wifi On");
                        break;
                    case WifiManager.WIFI_STATE_DISABLED:
                        wifiSwitch.setChecked(false);
                        wifiSwitch.setText("Turn_Wifi Off");
                        break;
                }
            }
        };
}

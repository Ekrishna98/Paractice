package com.example.practice.BletoothDemo;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.practice.R;

public class BluetoothDemo extends AppCompatActivity {

    Button Bluetooth;
    BluetoothManager bluetoothManager;
    public static final int REQUEST_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_demo);
        Bluetooth = findViewById(R.id.btnBluetooth);
        bluetoothManager = (BluetoothManager) getApplicationContext().getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null){
            Toast.makeText(this, "This device Doesn't support Bluetooth", Toast.LENGTH_SHORT).show();
        }
        if(!bluetoothAdapter.isEnabled()){
            Bluetooth.setText("Turn On Bluetooth");
        }else{
            Bluetooth.setText("Turn Off Bluetooth");
        }

        Bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(!bluetoothAdapter.isEnabled()){
                  Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                  startActivityForResult(bluetoothIntent,REQUEST_CODE);
              }else {
                  bluetoothAdapter.disable();
                  Bluetooth.setText("Turn on bluetooth");
              }
            }
        });
    }
}
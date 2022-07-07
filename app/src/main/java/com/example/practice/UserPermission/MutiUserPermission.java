package com.example.practice.UserPermission;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.practice.R;

public class MutiUserPermission extends AppCompatActivity {
    private String[] PERMISSIONS;
    private Button AskPermissions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_user_permissions);

        AskPermissions = findViewById(R.id.askpermission);

        PERMISSIONS = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.SEND_SMS,
                Manifest.permission.CAMERA
        };

        AskPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(MutiUserPermission.this, String.valueOf(PERMISSIONS)) ==
                PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MutiUserPermission.this, "you have already granted this permission", Toast.LENGTH_SHORT).show();
                }
                else{
                    requestStoragePermission();
                }
            }
        });
    }
    public void requestStoragePermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, String.valueOf(PERMISSIONS))){
            new AlertDialog.Builder(this).setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MutiUserPermission.this,PERMISSIONS,1);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }else {
        ActivityCompat.requestPermissions(this,PERMISSIONS,1);
    }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if(requestCode == 1){
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Calling is granted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Calling is denied", Toast.LENGTH_SHORT).show();
        }
        if(grantResults[1] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "SMS is granted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "SMS is denied", Toast.LENGTH_SHORT).show();
        }
        if(grantResults[2] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "CAMERA is granted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "CAMERA is denied", Toast.LENGTH_SHORT).show();
        }
    }


    }
}

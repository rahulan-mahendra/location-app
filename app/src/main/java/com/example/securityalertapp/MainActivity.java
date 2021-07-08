package com.example.securityalertapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        String phoneNumber = "0776041139";
        Intent intent = getIntent();
        String latitudename = intent.getStringExtra("latitude");
        String longitudename = intent.getStringExtra("longitude");
        String Message = "I’m Rahulan, IM/2017/057. Please Help Me.I’m in Latitude " +latitudename+ "Longitude" + longitudename+ ".";



        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber,null,Message,null,null);
    }

    public void cordnate(View view){

        Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
    }

    public void sendAlert(){

    }


}
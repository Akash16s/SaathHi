package com.example.akash.farmersassistant;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class Assistant extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;
    double latti,longi;
    LocationManager locationManager;
    Button AssistButton;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assistant);
        AssistButton=(Button) findViewById(R.id.assistant);   //Assist Button


        //**************
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);                     //Location Manager
        getLocation();
        //**************
    }


public void AssistCall(View view){
    Intent intent = new Intent(this,assistance.class);
    startActivity(intent);
}



public void weather(){

}
    void getLocation(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }else{
            Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location !=null){
                latti=location.getLatitude();
                longi=location.getLongitude();
            }
        }
    }




}
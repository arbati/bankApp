package com.example.bankconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFr=(SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFr.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map=googleMap;
        LatLng agency1=new LatLng(33.995762, -6.844835);
        map.addMarker(
                new MarkerOptions().position(agency1)
                        .title("Primary agency, Rabat")
                        .snippet("0533221122").draggable(true)
        );
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(agency1,10.0f));


        LatLng agency2=new LatLng(34.257909, -6.588641);
        map.addMarker(new MarkerOptions().position(agency2).title("Business agency, Kenitra").snippet("0533221123").draggable(true));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(agency2,10.0f));

        LatLng agency3=new LatLng(34.045189, -6.789525);
        map.addMarker(new MarkerOptions().position(agency3).title("Exchange agency, Sale").snippet("0533221124").draggable(true));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(agency3,10.0f));

        map.setOnInfoWindowClickListener(this);

    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {

        call(marker.getSnippet());
        Toast.makeText(getApplicationContext(),marker.getTitle(),Toast.LENGTH_SHORT).show();

    }


    public void call(String phone){

        String s="tel:"+phone;
        Intent intent= new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(s));

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        } else {
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

    }



}
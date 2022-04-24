package com.example.bankconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuAccount:
                Toast.makeText(getApplicationContext(),"Account",Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuTrsList:
                Intent intentTrs = new Intent(this,TransactionList.class);
                startActivity(intentTrs);
                break;

            case R.id.menuUsersList:
                Intent intentUsers = new Intent(this,UserList.class);
                startActivity(intentUsers);
                break;

            case R.id.menuLogout:
                Toast.makeText(getApplicationContext(),"Logout",Toast.LENGTH_SHORT).show();
                finishAffinity();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
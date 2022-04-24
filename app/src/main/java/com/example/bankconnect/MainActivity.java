package com.example.bankconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_EMAIL = "";
    private Button buttonLogIn;
    private EditText emailText;
    private EditText passwordText;
    private TextView textViewMsg;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!sharedPreferences.getString("login","default").equals("default") && !sharedPreferences.getString("password","default").equals("default")){
            Intent intent = new Intent(getApplicationContext(),TransactionList.class);
            startActivity(intent);
        }

    }

    public void init(){

        buttonLogIn =  findViewById(R.id.buttonLogIn);
        emailText =  findViewById(R.id.editTextUser);
        passwordText =  findViewById(R.id.editTextPassword);
        textViewMsg= findViewById(R.id.textViewMsg);

        buttonLogIn.setOnClickListener(onClickListener);
        textViewMsg.setText("");

    }


    public void logIn(String user, String password){

        sharedPreferences.edit().putString("login",user).commit();
        sharedPreferences.edit().putString("password",password).commit();
        Intent intent = new Intent(getApplicationContext(),TransactionList.class);
        startActivity(intent);

    }



    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String email = emailText.getText().toString();
            String password= passwordText.getText().toString();

           logIn(email,password);

        }
    };


    public void displayListTransaction(String email){
        Intent intent = new Intent(this, TransactionList.class);
        intent.putExtra(MESSAGE_EMAIL, email);
        startActivity(intent);
    }


    public void displayUserList(String email){
        Intent intent = new Intent(this, UserList.class);
        intent.putExtra(MESSAGE_EMAIL, email);
        startActivity(intent);
    }


}
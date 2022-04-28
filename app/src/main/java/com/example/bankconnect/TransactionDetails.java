package com.example.bankconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TransactionDetails extends BaseActivity {

    private ImageView txtIconTrs;
    private TextView txtLabelTrs;
    private TextView txtPriceTrs;
    private TextView txtDateTrs;
    private TextView txtAccountNum;
    private TextView txtSold;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);

        Intent intent = getIntent();
        Integer id = intent.getIntExtra("transaction",0);

        Transaction transaction = new TransactionDbHelper(TransactionDetails.this).findById(id);

        txtIconTrs = findViewById(R.id.txtIconTrs);
        txtLabelTrs = findViewById(R.id.txtLabelTrs);
        txtPriceTrs = findViewById(R.id.txtPriceTrs);
        txtDateTrs = findViewById(R.id.txtDateTrs);
        txtAccountNum= findViewById(R.id.txtAccountNum);
        txtSold= findViewById(R.id.txtSold);

        txtIconTrs.setImageResource(transaction.getIcon());
        txtLabelTrs.setText(transaction.getLabel());
        txtPriceTrs.setText(transaction.getPrice());
        txtDateTrs.setText(transaction.getDate());

        txtAccountNum.setText(transaction.getNumCompte());
        txtSold.setText(transaction.getSold()+"");



    }
}

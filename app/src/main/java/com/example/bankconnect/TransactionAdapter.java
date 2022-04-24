package com.example.bankconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter<Transaction> {

    ArrayList<Transaction> trans;
    public TransactionAdapter(@NonNull Context context, int resource, ArrayList<Transaction> trans) {
        super(context, resource,trans);
        this.trans = trans;
    }


    public TransactionAdapter(@NonNull Context context,  ArrayList<Transaction> trans) {
        super(context, R.layout.activity_transaction_list,trans);
        this.trans = trans;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.transaction_view,parent,false);

        Transaction transactionPosition = getItem(position);

        ImageView img = convertView.findViewById(R.id.transactionIcon);
        //img.setBackgroundResource(transactionPosition.getIcon());
        img.setImageResource(transactionPosition.getIcon());

        TextView label = convertView.findViewById(R.id.transactionLabel);
        label.setText(transactionPosition.getLabel());

        TextView price = convertView.findViewById(R.id.transactionPrice);
        price.setText(transactionPosition.getPrice());

        TextView date = convertView.findViewById(R.id.transactionDate);
        date.setText(transactionPosition.getDate());

        return convertView;
    }
}

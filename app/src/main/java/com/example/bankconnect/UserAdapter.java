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

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {


    public UserAdapter(@NonNull Context context, ArrayList<User> userArrayAdapter) {
        super(context, R.layout.activity_user_list, userArrayAdapter);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //View view = super.getView(position, convertView, parent);

        User userPosition = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_view,parent,false);
        }

        ImageView imgAvatar = convertView.findViewById(R.id.viewImgAvatar);
        TextView txtName = convertView.findViewById(R.id.viewTextName);
        TextView txtEmail = convertView.findViewById(R.id.viewTextEmail);
        TextView txtDate = convertView.findViewById(R.id.viewTextDate);
        TextView txtRole = convertView.findViewById(R.id.viewTextRole);

        imgAvatar.setImageResource(userPosition.getAvatar());
        txtName.setText(userPosition.getFirstName());
        txtEmail.setText(userPosition.getEmail());
        txtDate.setText(new SimpleDateFormat("dd/mm/yy HH:mm").format(userPosition.getCreatedAt()));
        txtRole.setText(userPosition.getRole());

        return convertView;
    }
}

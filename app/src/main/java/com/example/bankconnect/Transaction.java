package com.example.bankconnect;

import android.os.Parcel;
import android.os.Parcelable;

public class Transaction{
    int id;
    Integer icon;
    String label;
    String price;
    String date;
    String numCompte;
    String numRef;
    String sold;

    public Transaction(Integer icon, String label, String price, String date,String numCompte, String numRef, String sold) {
        this.icon = icon;
        this.label = label;
        this.price = price;
        this.date = date;
        this.numCompte = numCompte;
        this.numRef = numRef;
        this.sold = sold;
    }

    public Transaction(int id,Integer icon, String label, String price, String date,String numCompte, String numRef, String sold) {
        this.id = id;
        this.icon = icon;
        this.label = label;
        this.price = price;
        this.date = date;
        this.numCompte = numCompte;
        this.numRef = numRef;
        this.sold = sold;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getNumRef() {
        return numRef;
    }

    public void setNumRef(String numRef) {
        this.numRef = numRef;
    }

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

}

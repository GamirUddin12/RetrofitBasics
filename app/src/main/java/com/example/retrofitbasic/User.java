package com.example.retrofitbasic;

import com.google.gson.annotations.SerializedName;


public class User {
    @SerializedName("id")
    private int Id;
    @SerializedName("title")
    private String Name;
    @SerializedName("body")
    private String Address;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public User() {
    }


}

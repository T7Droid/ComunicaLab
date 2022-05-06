package com.example.comunicalablogin.ui.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserModel {

    public String username;
    public String email;
    public String id;

    public UserModel() {

    }

    public UserModel(String username, String email, String id) {
        this.username = username;
        this.email = email;
        this.id = id;
    }

}

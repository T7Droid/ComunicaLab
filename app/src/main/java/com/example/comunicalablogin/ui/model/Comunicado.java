package com.example.comunicalablogin.ui.model;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Comunicado {
    public String title;
    public String content;
    public String id;

    public Comunicado() {

    }

    public Comunicado(String title, String content, String id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }
}

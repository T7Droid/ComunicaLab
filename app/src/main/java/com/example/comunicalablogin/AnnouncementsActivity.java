package com.example.comunicalablogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class AnnouncementsActivity extends AppCompatActivity {

    private BootstrapButton backMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        backMenu = (BootstrapButton) findViewById(R.id.backMenu);

        backMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMenu();
            }
        });
    }

    public void backToMenu(){
        Intent intent = new Intent(this, UserMenuActivity.class);
        startActivity(intent);
        finish();
    }
}
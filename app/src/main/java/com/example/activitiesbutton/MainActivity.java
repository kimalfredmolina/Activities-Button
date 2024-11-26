package com.example.activitiesbutton;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button appbar = findViewById(R.id.appbar);
        Button contextual = findViewById(R.id.contextual);
        Button popup = findViewById(R.id.popup);
        Button dialogs = findViewById(R.id.dialogs);
        Button pickers = findViewById(R.id.pickers);

        appbar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AppBarCM.class);
            startActivity(intent);
        });

        contextual.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ContextualMenu.class);
            startActivity(intent);
        });

        popup.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PopupmenuActivity.class);
            startActivity(intent);
        });

        dialogs.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Dialogs.class);
            startActivity(intent);
        });

        pickers.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainPickers.class);
            startActivity(intent);


        });
    }
}
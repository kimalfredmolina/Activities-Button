package com.example.activitiesbutton;

import android.view.View;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.app.AppCompatActivity;

public class PopupmenuActivity extends AppCompatActivity {

    private ImageView imgMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupmenu);

        // Find the ImageView by its ID
        imgMore = findViewById(R.id.imgMore);

        // Set an onClickListener to show the PopupMenu
        imgMore.setOnClickListener(v -> showPopupMenu(v));
    }

    private void showPopupMenu(View view) {
        // Create a PopupMenu anchored to the ImageView
        PopupMenu popupMenu = new PopupMenu(PopupmenuActivity.this, view);

        // Inflate the menu resource
        popupMenu.inflate(R.menu.menu_popup);

        // Set the menu item click listener
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.items1) {
                Toast.makeText(this, "Menu 1", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (item.getItemId() == R.id.items2) {
                Toast.makeText(this, "Menu 2", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (item.getItemId() == R.id.items3) {
                Toast.makeText(this, "Menu 3", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        // Show the PopupMenu
        popupMenu.show();
    }
}

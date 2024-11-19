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

        imgMore = findViewById(R.id.imgMore);

        
        imgMore.setOnClickListener(v -> showPopupMenu(v));
    }

    private void showPopupMenu(View view) {
       
        PopupMenu popupMenu = new PopupMenu(PopupmenuActivity.this, view);

        
        popupMenu.inflate(R.menu.menu_popup);

        
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

        
        popupMenu.show();
    }
}

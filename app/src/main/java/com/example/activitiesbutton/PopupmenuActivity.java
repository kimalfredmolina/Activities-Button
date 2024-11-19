package com.example.activitiesbutton;

import android.os.Bundle;
import android.widget.ImageView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.PopupMenu;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class PopupmenuActivity extends AppCompatActivity {

    private ImageView imgMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.popupmenu);

        imgMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }
    private void showPopupMenu(View view){
        PopupMenu popupMenu =new PopupMenu(this, view);
        popupMenu.inflate(R.menu.menu_popup);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.items1) {
                    Toast.makeText(PopupmenuActivity.this, "Menu 1", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.items2) {
                    Toast.makeText(PopupmenuActivity.this, "Menu 2", Toast.LENGTH_SHORT).show();
                } else if (item.getItemId() == R.id.items3) {
                    Toast.makeText(PopupmenuActivity.this, "Menu 3", Toast.LENGTH_SHORT).show();
                } else {

                    // Handle the case where no matching item ID is found (optional)
                }
                return true;
            }
        });
        popupMenu.show();


    }
}
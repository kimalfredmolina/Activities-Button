package com.example.activitiesbutton;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ContextualMenu extends AppCompatActivity {

    private Button buttonFloatingMenu, buttonActionMode;
    private ActionMode mode = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_menu);

        buttonFloatingMenu = findViewById(R.id.buttonFloatingMenu);
        buttonActionMode = findViewById(R.id.buttonActionMode);

        // Register the floating context menu for the first button
        registerForContextMenu(buttonFloatingMenu);

        // Set up long click listener for the second button to trigger ActionMode
        buttonActionMode.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mode != null) return false; // If already in ActionMode, do nothing
                mode = startActionMode(actionModeCallback);
                return true;
            }
        });
    }

    // Floating Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.c_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Floating Menu: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    // Contextual Action Mode
    private final ActionMode.Callback actionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.c_menu, menu);
            mode.setTitle("Select Action");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.Heart:
                    Toast.makeText(ContextualMenu.this, "Action Mode: Liked", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Exit action mode
                    return true;
                case R.id.Shared:
                    Toast.makeText(ContextualMenu.this, "Action Mode: Shared", Toast.LENGTH_SHORT).show();
                    mode.finish(); // Exit action mode
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            ContextualMenu.this.mode = null; // Clear ActionMode reference
        }
    };

}

package com.example.activitiesbutton;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

public class MainDialogs {

    public static void showCustomDialog(Context context) {
        // Inflate the custom layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.activity_main, null);

        // Initialize dialog components
        TextView title = dialogView.findViewById(R.id.good_job);
        TextView description = dialogView.findViewById(R.id.description);
        Button okButton = dialogView.findViewById(R.id.ok);
        ImageView icon = dialogView.findViewById(R.id.icon);

        // Set content dynamically if needed
        title.setText("Good Job!");
        description.setText("You completed the task successfully.");
        icon.setImageResource(R.drawable.check); // Use your own drawable resource

        // Create the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);
        Dialog dialog = builder.create();

        // Handle button click
        okButton.setOnClickListener(v -> {
            dialog.dismiss(); // Dismiss the dialog on button click
        });

        // Show the dialog
        dialog.show();
    }
}

package com.example.activitiesbutton;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Dialogs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);

        showCustomDialog(this);
    }

    private void showCustomDialog(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.activity_dialogs, null); // Replace with your custom layout file name

        TextView titleTextView = dialogView.findViewById(R.id.good_job);
        TextView descriptionTextView = dialogView.findViewById(R.id.description);
        Button okButton = dialogView.findViewById(R.id.oks);
        ImageView iconImageView = dialogView.findViewById(R.id.icon);

        titleTextView.setText(getString(R.string.title));
        descriptionTextView.setText(getString(R.string.mini));
        iconImageView.setImageResource(R.drawable.img);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "OK button clicked!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }
}

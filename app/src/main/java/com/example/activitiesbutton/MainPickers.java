package com.example.activitiesbutton;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainPickers extends AppCompatActivity {

    private TextView tvSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pickers);

        Button btnPickDate = findViewById(R.id.btn_pick_date);
        tvSelectedDate = findViewById(R.id.tv_selected_date);


        btnPickDate.setOnClickListener(v -> showDatePickerDialog());
    }

    private void showDatePickerDialog() {

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(
                MainPickers.this,
                (DatePicker view, int selectedYear, int selectedMonth, int selectedDay) -> {

                    String formattedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String dateString = getString(R.string.selected_date, formattedDate);
                    tvSelectedDate.setText(dateString);
                },
                year, month, day
        );

        datePickerDialog.show();
    }
}

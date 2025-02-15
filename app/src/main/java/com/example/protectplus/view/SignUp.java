package com.example.protectplus.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.protectplus.R;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextInputEditText birthdateEditText = findViewById(R.id.birthdate);

        birthdateEditText.setOnClickListener(v -> {
            // Create a MaterialDatePicker instance
            MaterialDatePicker<Long> datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select your birthdate")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build();

            // Show the DatePicker dialog
            datePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");

            // Handle the selected date
            datePicker.addOnPositiveButtonClickListener(selection -> {
                // Convert the selected date to a readable format
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
                String formattedDate = sdf.format(selection);
                birthdateEditText.setText(formattedDate);
            });
        });
    }
}
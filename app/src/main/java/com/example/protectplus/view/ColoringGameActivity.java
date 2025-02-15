package com.example.protectplus.view;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.protectplus.R;
import com.example.protectplus.game.ColoringView;

import yuku.ambilwarna.AmbilWarnaDialog; // Color picker library

public class ColoringGameActivity extends AppCompatActivity {

    private ColoringView coloringView;
    private int selectedColor = Color.RED; // Default color

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloring_game);

        coloringView = findViewById(R.id.coloringView);
        Button colorPickerButton = findViewById(R.id.colorPickerButton);

        colorPickerButton.setOnClickListener(v -> openColorPicker());
    }

    private void openColorPicker() {
        AmbilWarnaDialog colorPickerDialog = new AmbilWarnaDialog(this, selectedColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                selectedColor = color;
                coloringView.setSelectedColor(color);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // Do nothing if user cancels
            }
        });
        colorPickerDialog.show();
    }
}

package com.example.protectplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.*;
import com.google.android.material.button.MaterialButton;

public class Lecture extends AppCompatActivity {

    private PDFView pdfView;
    private MaterialButton TakeQuiz;
    private TextView BackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        pdfView = findViewById(R.id.pdfView);
        TakeQuiz = findViewById(R.id.take_quiz_btn);
        BackBtn = findViewById(R.id.back_btn);

        pdfView.fromAsset("Scope.pdf").load();

//        // Load the PDF into the PDFView from db
//        pdfView.fromBytes(pdfBytes).load();
        TakeQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lecture.this, HomeScreen.class);
                startActivity(intent);
            }
        });

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
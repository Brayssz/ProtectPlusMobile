package com.example.protectplus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Login extends AppCompatActivity {

    private TextView tvRegister;
    private MaterialButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvRegister = findViewById(R.id.register);
        btnLogin = findViewById(R.id.sign_in_button);

        btnLogin.setOnClickListener(v -> {
            startActivity(new Intent(Login.this, Dashboard.class));
        });

        tvRegister.setOnClickListener(v -> {
           startActivity(new Intent(Login.this, SignUp.class));
        });
    }
}
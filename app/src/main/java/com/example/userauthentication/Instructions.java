package com.example.userauthentication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        Button button;

        button = findViewById(R.id.button4);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Instructions1.class);
            startActivity(intent);
        });

        Button button1= findViewById(R.id.button5);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(this, Instructions2.class);
            startActivity(intent);
        });

        Button button2= findViewById(R.id.button6);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Instructions3.class);
            startActivity(intent);
        });

    }
};

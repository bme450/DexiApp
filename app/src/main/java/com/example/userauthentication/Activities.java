package com.example.userauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Activities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);



        Button button = findViewById(R.id.button7);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activity1.class);
            startActivity(intent);
        });

        Button button1= findViewById(R.id.button8);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activity2.class);
            startActivity(intent);
        });

        Button button2= findViewById(R.id.button9);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activity3b.class);
            startActivity(intent);
        });

    }
};

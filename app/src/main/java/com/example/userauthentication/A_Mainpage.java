package com.example.userauthentication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;

public class A_Mainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__mainpage);

        

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, Instructions.class);
            startActivity(intent);

        });


        Button button2 = findViewById(R.id.button3);
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activities.class);
            startActivity(intent);
        });

    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout user
        startActivity(new Intent(A_Mainpage.this, MainActivityLogin.class));
        finish();
    }

};

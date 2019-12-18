package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AntraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antra);
        TextView receiver_msg = findViewById(R.id.textInputLayout);
        Intent intent = getIntent();
        String str = intent.getStringExtra("RANDOMSTRING");
        receiver_msg.setText(str);
    }
}

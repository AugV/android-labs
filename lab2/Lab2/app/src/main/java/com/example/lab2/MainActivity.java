package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SendButton = findViewById(R.id.button);
        final EditText send_text = findViewById(R.id.textInputLayout);

        SendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivity.this, AntraActivity.class);
                String str = send_text.getText().toString();
                Intent.putExtra("RANDOMSTRING", str);
                startActivity(Intent);
            }
        });
    }
}

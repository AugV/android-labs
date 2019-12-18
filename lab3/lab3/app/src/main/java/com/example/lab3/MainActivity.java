package com.example.lab3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText pavadinimas;
    EditText fakultetas;
    RatingBar sudetingumas;
    Spinner diena;
    TimePicker data;
    Switch registruotis;
    Button saugoti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pavadinimas = findViewById(R.id.editText3);
        fakultetas = findViewById(R.id.editText4);
        sudetingumas = findViewById(R.id.ratingBar);
        diena = findViewById(R.id.spinner3);
        data = findViewById(R.id.datePicker1);
        registruotis = findViewById(R.id.switch1);
        saugoti = findViewById(R.id.button);

        saugoti.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                String header = "Pavadinimas: " + pavadinimas.getText() + "\nFakultetas: " + fakultetas.getText() + "\n";
                String date = "Laikas: " + data.getHour() + " " + data.getMinute() + "\nDiena: " + diena.getSelectedItem().toString();
                String extra = "Sudetingumas: " + sudetingumas.getRating();
                if (registruotis.isChecked()) {
                    extra += "\nRegistruotacija bus vykdoma!";
                }

                Toast toast = Toast.makeText(getApplicationContext(),
                        header + "\n"
                                + date + "\n"
                                + extra,
                        Toast.LENGTH_SHORT);

                toast.show();

            }
        });
    }
}

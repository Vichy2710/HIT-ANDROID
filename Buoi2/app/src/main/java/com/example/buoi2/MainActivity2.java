package com.example.buoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView backToLogin1, backToLogin2, signup1;
    EditText email1, password1, username1, day1, month1, year1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        backToLogin1 = findViewById(R.id.back_to_login);
        backToLogin2 = findViewById(R.id.login);
        signup1 = findViewById(R.id.signup);

        username1 = findViewById(R.id.username);
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        day1 = findViewById(R.id.day);
        month1 = findViewById(R.id.day);
        year1 = findViewById(R.id.day);
        backToLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_Login = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(to_Login);
            }
        });
        backToLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_Login = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(to_Login);
            }
        });

        //deliver data
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deliData = new Intent(MainActivity2.this, MainActivity4.class);
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                String ema = email1.getText().toString();
                String d = day1.getText().toString();
                String m = month1.getText().toString();
                String y = year1.getText().toString();

                deliData.putExtra("S_NAME", user);
                deliData.putExtra("S_PASS", pass);
                deliData.putExtra("S_EMAIL", ema);
                deliData.putExtra("S_DAY", d);
                deliData.putExtra("S_MONTH", m);
                deliData.putExtra("S_YEAR", y);

                startActivity(deliData);
            }
        });

    }
}
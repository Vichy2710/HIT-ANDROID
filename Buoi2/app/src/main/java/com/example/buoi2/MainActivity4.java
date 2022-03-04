package com.example.buoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    EditText date1, ema, pass, user;
    TextView to_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        to_login = findViewById(R.id.login);
        date1= findViewById(R.id.date);
        ema= findViewById(R.id.email);
        pass= findViewById(R.id.password);
        user= findViewById(R.id.username);

        Intent getData = getIntent();
        String getD = getData.getStringExtra("S_DAY");
        String getM = getData.getStringExtra("S_MONTH");
        String getY = getData.getStringExtra("S_YEAR");
        String getUser = getData.getStringExtra("S_NAME");
        String getPass = getData.getStringExtra("S_PASS");
        String getEmail = getData.getStringExtra("S_EMAIL");

        date1.setText(getD+" / "+getM+" / "+getY);
        pass.setText(getPass);
        user.setText(getUser);
        ema.setText(getEmail);

        to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveToLogin = new Intent(MainActivity4.this, MainActivity.class);
                startActivity(moveToLogin);
            }
        });
    }
}
package com.example.buoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    TextView toLogin, username1, password1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        toLogin = findViewById(R.id.login);
        username1 = findViewById(R.id.username);
        password1 = findViewById(R.id.password);
        Intent getData = getIntent();
        String name = getData.getStringExtra("NAME");
        String pass = getData.getStringExtra("PASSWORD");

        username1.setText(name);
        password1.setText(pass);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_login = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(to_login);
            }
        });
    }
}
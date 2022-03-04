package com.example.buoi2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView sign_up, log_in;
    EditText username1, password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //move to signup screen
        sign_up = findViewById(R.id.btn_signup);
        log_in = findViewById(R.id.btn_login);
        sign_up.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_signup = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(to_signup);
            }
        });

        //get data
        username1 = findViewById(R.id.username);
        password1 = findViewById(R.id.password);
        log_in.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent deliData = new Intent(MainActivity.this, MainActivity3.class);
                String user = username1.getText().toString();
                String pass = password1.getText().toString();
                deliData.putExtra("NAME", user);
                deliData.putExtra("PASSWORD", pass);
                startActivity(deliData);
            }
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText tenDangNhap;
    EditText matKhau;
    CheckBox nhoMK;
    Button done;
    public void layID(){
        tenDangNhap = findViewById(R.id.tenDangNhap);
        matKhau = findViewById(R.id.matKhau);
        nhoMK = findViewById(R.id.nhoMK);
        done = findViewById(R.id.done);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        done.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String tenDN=tenDangNhap.getText().toString();
                String mk=matKhau.getText().toString();
                Boolean check=nhoMK.isChecked();
                Intent intent1= new Intent(MainActivity.this, Activity2.class);
                intent1.putExtra("tenDN", tenDN);
                intent1.putExtra("matKhau", mk);
                intent1.putExtra("nhoMK", check);

            }



        });
    }

}
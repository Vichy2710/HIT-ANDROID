package com.example.buoi1_maytinhbotui;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Precision;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView btnC, btnCE, phanTram;
    EditText display, fixedDisplay;
    TextView so1, so2, so3, so4, so5, so6, so7, so8, so9, so0, dauCham, bang;
    ImageButton cong, tru, nhan, chia;
    ImageButton xoaKyTu, motTrenX, canX, xBinh;
    Double soDau = 0.0, soSau = 0.0;
    int phepTinh = 0;
    StringBuilder value = new StringBuilder();
    StringBuilder fixed = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnC = findViewById(R.id.btnC);
        btnCE = findViewById(R.id.btnCE);
        phanTram = findViewById(R.id.phanTram);
        xoaKyTu = findViewById(R.id.xoaKyTu);
        motTrenX = findViewById(R.id.motTrenX);
        canX = findViewById(R.id.canBac2);
        xBinh = findViewById(R.id.xBinh);
        fixedDisplay = findViewById(R.id.fixedDisplay);
        display = findViewById(R.id.display);
        so1 = findViewById(R.id.so1);
        so2 = findViewById(R.id.so2);
        so3 = findViewById(R.id.so3);
        so4 = findViewById(R.id.so4);
        so5 = findViewById(R.id.so5);
        so6 = findViewById(R.id.so6);
        so7 = findViewById(R.id.so7);
        so8 = findViewById(R.id.so8);
        so9 = findViewById(R.id.so9);
        so0 = findViewById(R.id.so0);
        dauCham = findViewById(R.id.dauCham);

        cong = findViewById(R.id.cong);
        tru = findViewById(R.id.tru);
        nhan = findViewById(R.id.nhan);
        chia = findViewById(R.id.chia);
        bang = findViewById(R.id.bang);

        so1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('1');
                fixed.append('1');
                display.setText(value);
                fixedDisplay.setText(fixed);
            }
        });
        so2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('2');
                fixed.append('2');
                display.setText(value);
                fixedDisplay.setText(fixed);
            }
        });
        so3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('3');
                display.setText(value);
                fixed.append('3');
                fixedDisplay.setText(fixed);
            }
        });
        so4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('4');
                display.setText(value);
                fixed.append('4');
                fixedDisplay.setText(fixed);
            }
        });
        so5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('5');
                display.setText(value);
                fixed.append('5');
                fixedDisplay.setText(fixed);
            }
        });
        so6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('6');
                display.setText(value);
                fixed.append('6');
                fixedDisplay.setText(fixed);
            }
        });
        so7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('7');
                display.setText(value);
                fixed.append('7');
                fixedDisplay.setText(fixed);
            }
        });
        so8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('8');
                display.setText(value);
                fixed.append('8');
                fixedDisplay.setText(fixed);
            }
        });
        so9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('9');
                display.setText(value);
                fixed.append('9');
                fixedDisplay.setText(fixed);
            }
        });
        so0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('0');
                display.setText(value);
                fixed.append('0');
                fixedDisplay.setText(fixed);
            }
        });
        dauCham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.append('.');
                display.setText(value);
                fixed.append('.');
                fixedDisplay.setText(fixed);
            }
        });

        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phepTinh = 1;
                soDau = Double.parseDouble(value.toString());
                value.setLength(0);
                fixed.append('+');
                fixedDisplay.setText(fixed);
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phepTinh = 2;
                soDau = Double.parseDouble(value.toString());
                value.setLength(0);
                fixed.append('-');
                fixedDisplay.setText(fixed);
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phepTinh = 3;
                soDau = Double.parseDouble(value.toString());
                value.setLength(0);
                fixed.append('*');
                fixedDisplay.setText(fixed);

            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phepTinh = 4;
                soDau = Double.parseDouble(value.toString());
                value.setLength(0);
                fixed.append('/');
                fixedDisplay.setText(fixed);
            }
        });

        bang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phepTinh == 1) {
                    soDau += Double.parseDouble(value.toString());
                } else if (phepTinh == 2) {
                    soDau -= Double.parseDouble(value.toString());
                } else if (phepTinh == 3) {
                    soDau *= Double.parseDouble(value.toString());
                } else if (phepTinh == 4) {
                    soDau /= Double.parseDouble(value.toString());
                }else{
                    soDau=Double.parseDouble(value.toString());
                }
                display.setText(soDau.toString());
                fixed.setLength(0);
                value.setLength(0);
                value.append(soDau.toString());
                fixed.setLength(0);
                phepTinh=0;
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixed.setLength(0);
                value.setLength(0);
                soDau = 0.0;
                display.setText(value);
                fixedDisplay.setText(fixed);
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value.setLength(0);
                display.setText(value);
                fixed.setLength(0);
                fixedDisplay.setText(fixed);
            }
        });

        phanTram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixed.setLength(0);
                fixedDisplay.setText(fixed);
                Double tmp;
                if(value.length()==0)
                    tmp=soDau/100;
                else
                    tmp=Double.parseDouble(value.toString())/100;
                soDau=tmp;
                value.setLength(0);
                value.append(soDau.toString());
                display.setText(tmp.toString());
            }
        });

        canX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixed.setLength(0);
                fixedDisplay.setText(fixed);
                Double tmp;
                if(value.length()==0)
                    tmp=Math.sqrt(soDau);
                else
                    tmp=Math.sqrt(Double.parseDouble(value.toString()));
                soDau=tmp;
                value.setLength(0);
                value.append(soDau.toString());
                display.setText(tmp.toString());
            }
        });

        motTrenX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixed.setLength(0);
                fixedDisplay.setText(fixed);
                Double tmp;
                if(value.length()==0)
                    tmp=1/soDau;
                else
                    tmp=1/Double.parseDouble(value.toString());
                soDau=tmp;
                value.setLength(0);
                value.append(soDau.toString());
                display.setText(tmp.toString());
            }
        });

        xBinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixed.setLength(0);
                fixedDisplay.setText(fixed);
                Double tmp;
                if(value.length()==0)
                    tmp=soDau*soDau;
                else
                    tmp=Double.parseDouble(value.toString()) * Double.parseDouble(value.toString());
                soDau=tmp;
                value.setLength(0);
                value.append(soDau.toString());
                display.setText(tmp.toString());
            }
        });

        xoaKyTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixed.deleteCharAt(fixed.length()-1);
                fixedDisplay.setText(fixed);
                value.deleteCharAt(value.length()-1);
                display.setText(value);
            }
        });
    }
}
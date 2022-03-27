package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ChiTietMonAn extends AppCompatActivity {

    ImageView avt_monan;
    TextView tenmon, nguyenlieu_monan, congthuc_monan, chiphi_monan;

    TextView backToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mon_an);

        Bundle bundle = getIntent().getExtras();
        MonAn monAn = (MonAn) bundle.get("MonAn");

        //System.out.println(monAn)  ;
        tenmon = findViewById(R.id.tenmon);
        avt_monan = findViewById(R.id.avt_monan);
        nguyenlieu_monan = findViewById(R.id.nguyenlieu_monan);
        congthuc_monan = findViewById(R.id.congthuc_monan);
        chiphi_monan = findViewById(R.id.chiphi_monan);

        tenmon.setText(monAn.getMoanname());
        Picasso.get().load(monAn.getAvt()).into(avt_monan);
        nguyenlieu_monan.setText(monAn.getNguyenlieu());
        congthuc_monan.setText(monAn.getCongthuc());
        chiphi_monan.setText(monAn.getTien());

        backToMain = findViewById(R.id.backToMain);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMain = new Intent(ChiTietMonAn.this, MainActivity.class);
                startActivity(toMain);
            }
        });
    }
}
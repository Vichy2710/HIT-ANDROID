package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Database database;

    GridView gridViewCV;
    ArrayList<CongViec> arrayListCV;
    CongViecAdapter congViecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewCV = findViewById(R.id.list);
        arrayListCV = new ArrayList<>();

        congViecAdapter = new CongViecAdapter(this, R.layout.one_note, arrayListCV);
        gridViewCV.setAdapter(congViecAdapter);

        // tao database
        database = new Database(this, "GhiChu.sqlite", null, 1);

        // tao bang
        database.QueryData("CREATE TABLE IF NOT EXISTS CongViec(id INTEGER PRIMARY KEY AUTOINCREMENT, ten VARCHAR)");

        // them du lieu
        // database.QueryData("INSERT INTO CongViec VALUES(null, 'Lam bai android')");

        getData();

        RelativeLayout add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_add_note();
            }
        });
    }


    private void dialog_add_note(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_note);

        EditText editText = dialog.findViewById(R.id.add_note);
        TextView add_btn = dialog.findViewById(R.id.btn_add);
        TextView cancel_btn = dialog.findViewById(R.id.btn_cancel_add);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = editText.getText().toString();
                if(note.equals("")){
                    dialog.dismiss();
                }else{
                    database.QueryData("INSERT INTO CongViec VALUES(null, '"+note+"')");
                    dialog.dismiss();
                    getData();
                }
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void dialog_edit_note(String ten, int id){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit_note);

        EditText editText = dialog.findViewById(R.id.edit_note);
        TextView edit_btn = dialog.findViewById(R.id.btn_edit);
        TextView cancel_btn = dialog.findViewById(R.id.btn_cancel_edit);

        editText.setText(ten);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newNote = editText.getText().toString().trim();
                database.QueryData("UPDATE CongViec SET ten = '"+newNote+"' WHERE id='"+id+"'");
                dialog.dismiss();
                getData();
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void dialog_show_note(String ten){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.show_note);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        TextView textView = dialog.findViewById(R.id.show_note);
        ImageView imageView = dialog.findViewById(R.id.quit_btn);

        textView.setText(ten);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void dialog_erase_note(int id){
        AlertDialog.Builder eraseDialog = new AlertDialog.Builder(this);
        eraseDialog.setMessage("Are you sure you want to delete?");
        eraseDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.QueryData("DELETE FROM CongViec WHERE id='"+id+"'");
                getData();
            }
        });
        eraseDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        eraseDialog.show();
    }

    private void getData(){
        // select data
        Cursor dataCongViec = database.GetData("SELECT * FROM CongViec");
        arrayListCV.clear();
        while (dataCongViec.moveToNext()){
            String ten = dataCongViec.getString(1);
            int id= dataCongViec.getInt(0);
            arrayListCV.add(new CongViec(id, ten));
        }

        congViecAdapter.notifyDataSetChanged();
    }
}
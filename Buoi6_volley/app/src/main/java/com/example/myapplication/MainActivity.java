package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MonAn> monAns = new ArrayList<>();
    RecyclerView recyclerView;
    String url = "https://appnote-codernon.herokuapp.com/api/monan";
    MonAnAdapter monAnAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        GetData();
    }
    public void GetData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<=response.length();i++){
                    try {
                        JSONObject jsonObject =response.getJSONObject(i);
                        monAns.add(new MonAn(
                                jsonObject.getInt("monanId"),
                                jsonObject.getString("moanname"),
                                jsonObject.getString("avt"),
                                jsonObject.getString("nguyenlieu"),
                                jsonObject.getString("congthuc"),
                                jsonObject.getString("tien")

                        ));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                monAnAdapter=new MonAnAdapter(getApplicationContext(),monAns);
                LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
                recyclerView.setAdapter(monAnAdapter);
                recyclerView.setLayoutManager(linearLayoutManager);
                //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
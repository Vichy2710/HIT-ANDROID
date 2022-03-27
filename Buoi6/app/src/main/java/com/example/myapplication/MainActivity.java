package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.api.IApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private List<MonAn> monAns;
    private RecyclerView recyclerView;
    private Adapter_MonAn adapter_monAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        recyclerView = findViewById(R.id.ds_mon_an);
        monAns = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter_monAn = new Adapter_MonAn();

        getAllMonAn();

    }
    public void getAllMonAn(){
        Call<List<MonAn>> monAnList = RetrofitClient.getIApiService().getAll("IwAR3Z26Wx-3O1jxdpPBCSZXW2OfeL05cQHz3fTCBoXHjpLzYfan4US2HQRUM");
        monAnList.enqueue(new Callback<List<MonAn>>() {
            @Override
            public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
                if(response.isSuccessful()){
                    Log.e("Success", response.body().toString());
                    adapter_monAn.setData(monAns);
                    List<MonAn> monAns = response.body();

                }
            }

            @Override
            public void onFailure(Call<List<MonAn>> call, Throwable t) {
                Log.e("Failure", t.getLocalizedMessage());
                recyclerView.setAdapter(adapter_monAn);
            }
        });
    }
//    private void callAPI() {
//        IApiService.apiService.convertMonAn("IwAR3Z26Wx-3O1jxdpPBCSZXW2OfeL05cQHz3fTCBoXHjpLzYfan4US2HQRUM")
//                .enqueue(new Callback<List<MonAn>>() {
//
//                    @Override
//                    public void onResponse(Call<List<MonAn>> call, Response<List<MonAn>> response) {
//                        List<MonAn> monAns = response.body();
//                        for (int i=0;i<length)
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<MonAn>> call, Throwable t) {
//                        Toast.makeText(MainActivity.this, "Error when calling API", Toast.LENGTH_SHORT);
//
//                    }
//                });
//    }
}
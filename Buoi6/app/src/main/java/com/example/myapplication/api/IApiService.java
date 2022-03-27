package com.example.myapplication.api;

import com.example.myapplication.MonAn;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {
    // Link API: https://appnote-codernon.herokuapp.com/api/monan?fbclid=IwAR3Z26Wx-3O1jxdpPBCSZXW2OfeL05cQHz3fTCBoXHjpLzYfan4US2HQRUM
//    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//
//    IApiService apiService = new Retrofit.Builder()
//            .baseUrl("https://appnote-codernon.herokuapp.com/")
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .build()
//            .create(IApiService.class);

    @GET("api/monan")
    Call<List<MonAn>> getAll(@Query("fbclid") String fbclid);
}

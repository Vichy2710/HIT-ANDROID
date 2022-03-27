package com.example.myapplication;

import com.example.myapplication.api.IApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private  static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://appnote-codernon.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        return retrofit;
    }
    public static IApiService getIApiService(){
        IApiService iApiService = getRetrofit().create(IApiService.class);
        return iApiService;
    }
}

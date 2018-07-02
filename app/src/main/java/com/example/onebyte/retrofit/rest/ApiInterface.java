package com.example.onebyte.retrofit.rest;

import com.example.onebyte.retrofit.model.joke;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("jokes")
    Call<joke> getJokes();

}
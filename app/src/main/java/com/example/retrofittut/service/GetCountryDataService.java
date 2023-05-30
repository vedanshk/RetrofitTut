package com.example.retrofittut.service;

import com.example.retrofittut.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetCountryDataService {

    @GET("countries")
    Call<Result> listCountries();

}

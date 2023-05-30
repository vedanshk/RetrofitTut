package com.example.retrofittut;

import com.example.retrofittut.service.GetCountryDataService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {

    private static  Retrofit retrofit  = null;
    private static final String baseUrl = "https://api.printful.com";

     public static  synchronized GetCountryDataService getService() {
        if(retrofit == null){
             retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(GetCountryDataService.class);
    }

}

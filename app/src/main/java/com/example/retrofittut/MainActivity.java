package com.example.retrofittut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofittut.model.Result;
import com.example.retrofittut.model.Country;
import com.example.retrofittut.service.GetCountryDataService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ArrayList<Country> countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         GetCountries();

    }

    private ArrayList<Country> GetCountries() {
        GetCountryDataService service = RetrofitInstance.getService();
        Call<Result> call = service.listCountries();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(@NonNull Call<Result> call, @NonNull Response<Result> response) {

                Result result = response.body();


                assert result != null;
                countries =  (ArrayList<Country>) result.getResult();
                    for(Country c : countries){
                        Log.i("TAG"  , "" + c.getName());
                        Log.d(TAG, "onResponse: Hello");

                }

            }

            @Override
            public void onFailure(@NonNull Call<Result> call, @NonNull Throwable t) {

            }
        });


        return countries;
    }


}
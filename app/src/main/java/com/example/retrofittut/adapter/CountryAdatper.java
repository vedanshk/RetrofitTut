package com.example.retrofittut.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofittut.R;
import com.example.retrofittut.model.Country;

import java.util.ArrayList;

public class CountryAdatper extends  RecyclerView.Adapter<CountryAdatper.CountryViewHolder>{

    private Context context;
    private ArrayList<Country> countries = new ArrayList<Country>();

    public CountryAdatper(Context context) {
        this.context = context;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.country_item , parent  , false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.txtCountry.setText(countries.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static  class  CountryViewHolder extends RecyclerView.ViewHolder{

        private final TextView txtCountry;
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCountry  = itemView.findViewById(R.id.txtCountry);
        }

    }
}

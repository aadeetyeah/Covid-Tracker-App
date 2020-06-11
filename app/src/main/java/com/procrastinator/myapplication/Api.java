package com.procrastinator.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    //String BASE_URL="https://corona.lmao.ninja/v2/";
    String BASE_URL="https://disease.sh/v2/";//countries?allowNull=false
    @GET("all")
    Call<List<AllData>> getAll();
    @GET("countries?allowNull=false")
    Call<List<CasesData>> getCasesData();

}

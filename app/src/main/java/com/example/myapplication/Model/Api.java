package com.example.myapplication.Model;

import com.example.myapplication.Model.Change;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("changes/")
    Call<List<Change>> loadChanges(@Query("q") String status);
}

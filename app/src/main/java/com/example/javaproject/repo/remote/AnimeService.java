package com.example.javaproject.repo.remote;

import com.example.javaproject.model.AnimeResponse;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface AnimeService {
    //?q={search}
    @GET(".")
    Call<AnimeResponse>getAnime(@Query("q") String search);

}

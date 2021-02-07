package com.example.javaproject.repo.remote;

import com.example.javaproject.model.AnimeResponse;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {
    @GET("?q=fate")
    Call<AnimeResponse>getAnime();

}

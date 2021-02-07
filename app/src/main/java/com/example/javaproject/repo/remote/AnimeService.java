package com.example.javaproject.repo.remote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {
    @GET("?q=fate")
    Call<List<String>>getAnime();

}

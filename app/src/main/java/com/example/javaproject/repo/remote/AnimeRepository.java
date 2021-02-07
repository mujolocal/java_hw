package com.example.javaproject.repo.remote;

import com.example.javaproject.model.AnimeResponse;
import com.example.javaproject.repo.RetrofitInstance;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;

public class AnimeRepository {
    private static AnimeRepository INSTANCE = null;

    private AnimeRepository() {

    }

    public Call<AnimeResponse> getAnime() {
        AnimeService animeService = RetrofitInstance.getInstance();
        return animeService.getAnime();
    }

    public static AnimeRepository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AnimeRepository();
        return INSTANCE;
    }
}

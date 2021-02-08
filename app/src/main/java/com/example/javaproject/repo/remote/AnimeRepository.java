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

    public Call<AnimeResponse> getAnime(String search) {
        AnimeService animeService = RetrofitInstance.getInstance();
        return animeService.getAnime(search);
    }

    public static AnimeRepository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AnimeRepository();
        return INSTANCE;
    }
}

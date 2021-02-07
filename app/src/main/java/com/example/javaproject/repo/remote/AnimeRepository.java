package com.example.javaproject.repo.remote;

import com.example.javaproject.repo.RetrofitInstance;

import java.util.List;

import retrofit2.Call;

public class AnimeRepository {
    private static AnimeRepository INSTANCE = null;

    private AnimeRepository() {

    }

    public Call<List<String>> getShibes() {
        AnimeService shibeService = RetrofitInstance.getInstance();
        return shibeService.getAnime();
    }

    public static AnimeRepository getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AnimeRepository();
        return INSTANCE;
    }
}

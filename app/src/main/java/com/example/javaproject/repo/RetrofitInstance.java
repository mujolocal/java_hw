package com.example.javaproject.repo;

import com.example.javaproject.repo.remote.AnimeService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://api.jikan.moe/v3/search/anime/";

    // Step 1: Declare instance initialized as null
    private static AnimeService INSTANCE = null;

    // Step 2: Make the constructor private
    private RetrofitInstance() {

    }

//    private static Retrofit getRetrofit() {
//        return new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(MoshiConverterFactory.create())
//                .client(getClient())
//                .build();
//    }

    // Step 3: Public method to access the new instance
    public static AnimeService getInstance() {
        if (INSTANCE == null)
//            INSTANCE = getRetrofit().create(AnimeService.class);
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .client(getClient())
                    .build()
                    .create(AnimeService.class);

        return INSTANCE;
    }


    private static OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
    }
}

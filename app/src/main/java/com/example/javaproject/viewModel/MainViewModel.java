package com.example.javaproject.viewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.javaproject.model.AnimeResponse;
import com.example.javaproject.repo.remote.AnimeRepository;
import com.squareup.moshi.Moshi;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private static final String TAG = "MainViewModel";
    private String jsonString;
    private JSONObject jsonObject;
    private JSONArray jsonArray;

    public void fetchAnime() {
        AnimeRepository animeRepository = AnimeRepository.getInstance();
        animeRepository.getAnime().enqueue(new Callback<AnimeResponse>() {

            @Override
            public void onResponse(Call<AnimeResponse> call, Response<AnimeResponse> response) {
                Log.d(TAG, "onResponse: worked");
                Log.d(TAG, "onResponse: "+response.body().toString());
                Log.d(TAG, "onResponse: "+call.toString());
            }

            @Override
            public void onFailure(Call<AnimeResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: didnt work");
            }
        });
    }

    private void parseJson(Response<List<String>> response){
        jsonString = response.body().toString();
        try {
            jsonObject = new JSONObject(jsonString);
            Log.d(TAG, "parseJson: "+jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonArray = new JSONArray(jsonObject.getJSONArray("results"));
            Log.d(TAG, "parseJson: "+jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

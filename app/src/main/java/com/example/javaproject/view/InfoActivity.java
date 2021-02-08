package com.example.javaproject.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.javaproject.databinding.ActivityInfoBinding;
import com.example.javaproject.model.Anime;

public class InfoActivity extends AppCompatActivity {
    private static final String TAG = "InfoActivity";
    private Anime anime;
    private ActivityInfoBinding binding;
    private String chosenAnime = "chosen_anime";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        anime =(Anime) intent.getSerializableExtra(chosenAnime);
        Log.d(TAG, "onCreate: "+anime.toString());
    }
}

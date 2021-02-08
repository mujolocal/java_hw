package com.example.javaproject.view;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.javaproject.R;
import com.example.javaproject.databinding.ActivityInfoBinding;
import com.example.javaproject.model.Anime;

import java.io.InputStream;
import java.net.URL;

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
        fillInfo();


    }

    private void fillInfo(){
        binding.animeName.setText(anime.getTitle());
        binding.score.setText(String.valueOf(anime.getScore()));
        binding.synopsis.setText(anime.getSynopsis());
        Glide.with(this).load(anime.getImage_url()).into(binding.animeImage);

    }


}

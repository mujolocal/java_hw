package com.example.javaproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.javaproject.R;
import com.example.javaproject.adapter.RecyclerAdapter;
import com.example.javaproject.databinding.ActivityMainBinding;
import com.example.javaproject.model.Anime;
import com.example.javaproject.model.AnimeResponse;
import com.example.javaproject.model.Asset;
import com.example.javaproject.repo.remote.AnimeRepository;
import com.example.javaproject.repo.remote.AnimeService;
import com.example.javaproject.viewModel.Click;
import com.example.javaproject.viewModel.MainViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Toast toast;
    private static final String TAG = "MainActivity";
    private ArrayList<Anime> assets = new ArrayList<>();
    private MainViewModel mainViewModel;
    private RecyclerAdapter recyclerAdapter;
    private String chosenAnime = "chosen_anime";
    private Click click;
    private List<String> string = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);


        initViews();
        initActions();
        initObservers();
        mainViewModel.fetchAnime("aaaa");
        click = new Click(MainActivity.this);
        recyclerAdapter = new RecyclerAdapter(assets, click);
        binding.recycleView.setAdapter(recyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recycleView.setLayoutManager(linearLayoutManager);

        binding.searchTxtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void initObservers(){
        mainViewModel.getAnimeResponse().observe(this, new Observer<AnimeResponse>() {
            @Override
            public void onChanged(AnimeResponse animeResponse) {
                setAssets(animeResponse);
            }
        });


    }


    private void setAssets(AnimeResponse animeResponse) {
        Log.d(TAG, "setAssets: "+animeResponse);
        for (Anime anime:animeResponse.getResults()){
            assets.add(anime);
        }
    }

    private void initActions() {
        binding.gridBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(binding.getRoot().getContext(), 2);
                binding.recycleView.setLayoutManager(gridLayoutManager);
            }
        });
        binding.listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(binding.getRoot().getContext());
                binding.recycleView.setLayoutManager(linearLayoutManager);
            }
        });

        binding.fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: "+binding.searchTxtInput.getText().toString());
                assets.clear();
                mainViewModel.fetchAnime(binding.searchTxtInput.getText().toString());
                Log.d(TAG, "onClick: "+assets);
                recyclerAdapter.setAssets(assets);
                recyclerAdapter.notifyDataSetChanged();

            }
        });


    }

    private void initViews() {
        binding.toggleLayoutBtn.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if (isChecked) {
                    if (checkedId == R.id.grid_btn) {

                        Log.d(TAG, "onButtonChecked: toast should have started");
                    } else if (checkedId == R.id.list_btn) {
                        Log.d(TAG, "onButtonChecked:should have started");
                    }
                } else {
                    Log.d(TAG, "onButtonChecked: nothing checked");
                }
            }
        });

    }
}
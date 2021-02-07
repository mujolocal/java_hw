package com.example.javaproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.javaproject.R;
import com.example.javaproject.adapter.RecyclerAdapter;
import com.example.javaproject.databinding.ActivityMainBinding;
import com.example.javaproject.model.Asset;
import com.example.javaproject.repo.remote.AnimeRepository;
import com.example.javaproject.repo.remote.AnimeService;
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
    private ArrayList<Asset> assets = new ArrayList<Asset>();
    private AnimeService animeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());


        setAssets();
        initViews();
        initActions();

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(assets);
        binding.recycleView.setAdapter(recyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recycleView.setLayoutManager(linearLayoutManager);




    }

    private void setAssets() {
        assets.add(new Asset("one"));
        assets.add(new Asset("two"));
        assets.add(new Asset("3"));
        assets.add(new Asset("4"));
        assets.add(new Asset("5"));
        assets.add(new Asset("one"));
        assets.add(new Asset("two"));
        assets.add(new Asset("3"));
        assets.add(new Asset("4"));
        assets.add(new Asset("5"));
        assets.add(new Asset("one"));
        assets.add(new Asset("two"));
        assets.add(new Asset("3"));
        assets.add(new Asset("4"));
        assets.add(new Asset("5"));
    }
    private void initActions(){
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
                Log.d(TAG, "onClick: fetching");
                AnimeRepository animeRepository = AnimeRepository.getInstance();
                animeRepository.getShibes().enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        Log.d(TAG, "onResponse: "+response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {

                    }
                });

            }
        });

    }

    private void initViews(){
        binding.toggleLayoutBtn.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(isChecked){
                if(checkedId == R.id.grid_btn){

                    Log.d(TAG, "onButtonChecked: toast should have started");
                }else if(checkedId == R.id.list_btn){
                    Log.d(TAG, "onButtonChecked:should have started");
                }}else{
                    Log.d(TAG, "onButtonChecked: nothing checked");
                }
            }
        });

    }
}
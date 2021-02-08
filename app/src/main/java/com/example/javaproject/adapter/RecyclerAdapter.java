package com.example.javaproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaproject.databinding.AssetImageBinding;
import com.example.javaproject.model.Anime;
import com.example.javaproject.model.AnimeResponse;
import com.example.javaproject.model.Asset;
import com.example.javaproject.view.InfoActivity;
import com.example.javaproject.view.MainActivity;
import com.example.javaproject.viewModel.Click;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder> {
    private ArrayList<Anime> assets;
    private Click click;
    private String chosenAnime = "chosen_anime";

    public RecyclerAdapter(ArrayList<Anime> assets, Click click){
        this.assets = assets;
        this.click = click;
    }

    public void setAssets(ArrayList<Anime> assets) {
        this.assets = assets;
    }

    private static final String TAG = "RecyclerAdapter";
    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AssetImageBinding binding = AssetImageBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new AdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        holder.setLayout(assets.get(position));
    }

    @Override
    public int getItemCount() {
        return assets.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder{
        private final AssetImageBinding binding;

        public AdapterViewHolder(@NonNull AssetImageBinding assetImageBinding ) {
            super(assetImageBinding.getRoot());
            this.binding = assetImageBinding;

        }

        public void setLayout(Anime anime){
            binding.txt.setText(anime.getTitle());
            click.setLinearLayout(binding.getRoot());
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(click.getMainActivity(),InfoActivity.class);
                    intent.putExtra(chosenAnime, anime);
                    click.getMainActivity().startActivity(intent);
                }
            });
        }

    }
}

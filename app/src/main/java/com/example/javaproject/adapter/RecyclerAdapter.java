package com.example.javaproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaproject.databinding.AssetImageBinding;
import com.example.javaproject.model.Asset;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.AdapterViewHolder> {
    private ArrayList<Asset> assets;
    public RecyclerAdapter(ArrayList<Asset> assets){
        this.assets = assets;
    }

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
        holder.setLayout(assets.get(position).getName());
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

        public void setLayout(String name){
            binding.txt.setText(name);
        }

    }
}

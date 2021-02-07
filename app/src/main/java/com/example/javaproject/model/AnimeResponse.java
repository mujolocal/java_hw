package com.example.javaproject.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class AnimeResponse {
    private String request_hash;
    private boolean request_cached;
    private int request_cache_expiry;
    private List<Anime>results = new ArrayList<Anime>();

    public AnimeResponse(String request_hash, boolean request_cached, int request_cache_expiry, ArrayList<Anime> results) {
        this.request_hash = request_hash;
        this.request_cached = request_cached;
        this.request_cache_expiry = request_cache_expiry;
        this.results = results;
    }

    public String getRequest_hash() {
        return request_hash;
    }

    public void setRequest_hash(String request_hash) {
        this.request_hash = request_hash;
    }

    public boolean isRequest_cached() {
        return request_cached;
    }

    public void setRequest_cached(boolean request_cached) {
        this.request_cached = request_cached;
    }

    public int getRequest_cache_expiry() {
        return request_cache_expiry;
    }

    public void setRequest_cache_expiry(int request_cache_expiry) {
        this.request_cache_expiry = request_cache_expiry;
    }

    public List<Anime> getResults() {
        return results;
    }

    public void setResults(List<Anime> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Anime ani:results){
            stringBuilder.append(ani.toString());
        }
        return stringBuilder.toString();
    }
}

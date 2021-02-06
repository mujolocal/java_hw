package com.example.javaproject.model;

import androidx.annotation.NonNull;

import java.security.PublicKey;

public class Asset {
    private String name;
    private String image_url;
    private String description;


    public Asset(String name){
        setName(name);
    }
    public  Asset(String name, String image_url, String description){
        setName(name);
        setImage_url(image_url);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}

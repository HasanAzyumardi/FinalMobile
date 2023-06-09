package com.example.h071211076_finalmobile.response;

import com.example.h071211076_finalmobile.model.ModelMovie;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("result")
    private ModelMovie modelMovie;


    public ModelMovie getModelMovie() {
        return modelMovie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "modelMovie=" + modelMovie +
                '}';
    }

}

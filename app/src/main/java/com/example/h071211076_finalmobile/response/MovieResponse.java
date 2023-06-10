package com.example.h071211076_finalmobile.response;

import com.example.h071211076_finalmobile.model.ModelMovie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    private List<ModelMovie> results;

    public MovieResponse(List<ModelMovie> results) {
        this.results = results;
    }

    public List<ModelMovie> getResults() {
        return results;
    }

    public void setResults(List<ModelMovie> results) {
        this.results = results;
    }
}

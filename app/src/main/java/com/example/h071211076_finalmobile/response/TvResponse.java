package com.example.h071211076_finalmobile.response;

import com.example.h071211076_finalmobile.model.ModelMovie;
import com.example.h071211076_finalmobile.model.ModelTv;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvResponse {
    @SerializedName("results")
    private List<ModelTv> results;

    public List<ModelTv> getResults() {
        return results;
    }

    public void setResults(List<ModelTv> results) {
        this.results = results;
    }


    public TvResponse(List<ModelTv> results) {
        this.results = results;
    }
}

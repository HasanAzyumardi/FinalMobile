package com.example.h071211076_finalmobile.utility;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviedbConfig {
    public static MoviedbAPI getMoviedbAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MoviedbAPI.class);

    }

}

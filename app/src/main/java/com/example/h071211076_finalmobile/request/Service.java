package com.example.h071211076_finalmobile.request;

import com.example.h071211076_finalmobile.utility.MoviedbAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
                    .baseUrl(Identity.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    private static Retrofit retrofit = retrofitBuilder.build();

    private static MoviedbAPI movieApi = retrofit.create(MoviedbAPI.class);

    public static MoviedbAPI getMovieApi(){
        return movieApi;
    }
}

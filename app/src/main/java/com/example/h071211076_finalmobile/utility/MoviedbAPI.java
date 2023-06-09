package com.example.h071211076_finalmobile.utility;

import com.example.h071211076_finalmobile.response.MovieResponse;
import com.example.h071211076_finalmobile.response.TvResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public class MoviedbAPI {
    @GET("movie/popular?api_key=98c347c771b297ec0a3404780e70da60")
    Call<MovieResponse> getPopularMovie(
    );

    @GET("tv/popular?api_key=98c347c771b297ec0a3404780e70da60")
    Call<TvResponse> getPopularTv(
    );

}

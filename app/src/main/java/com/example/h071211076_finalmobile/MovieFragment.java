package com.example.h071211076_finalmobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.h071211076_finalmobile.adapter.MovieAdapter;
import com.example.h071211076_finalmobile.model.ModelMovie;
import com.example.h071211076_finalmobile.response.MovieResponse;
import com.example.h071211076_finalmobile.utility.MoviedbConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment {

    RecyclerView rvMovie;
    MovieAdapter movieAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovie = view.findViewById(R.id.rvMovies);
        rvMovie.setHasFixedSize(true);
        rvMovie.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MoviedbConfig.getMoviedbAPI().getPopularMovie().enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ModelMovie> modelMovieList = response.body().getResults();
                    movieAdapter = new MovieAdapter(modelMovieList, MovieFragment.this);
                    rvMovie.setAdapter(movieAdapter);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }
}

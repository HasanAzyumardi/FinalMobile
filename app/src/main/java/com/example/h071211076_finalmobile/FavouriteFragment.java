package com.example.h071211076_finalmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211076_finalmobile.adapter.FavouriteMovieAdapter;
import com.example.h071211076_finalmobile.adapter.FavouriteTvAdapter;
import com.example.h071211076_finalmobile.database.DatabaseHelperMovie;
import com.example.h071211076_finalmobile.database.DatabaseHelperTv;
import com.example.h071211076_finalmobile.model.ModelMovie;
import com.example.h071211076_finalmobile.model.ModelTv;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment {

    private static final int DETAIL_ACTIVITY_REQUEST_CODE = 1;

    private RecyclerView rvFavouriteMovies, rvFavouriteTvShows;
    private DatabaseHelperMovie databaseHelperMovie;
    private FavouriteMovieAdapter favouriteMovieAdapter;
    private FavouriteTvAdapter favouriteTvAdapter;
    private DatabaseHelperTv databaseHelperTv;
    private List<ModelMovie> favouriteMovies;
    private List<ModelTv> favouriteTvShows;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);
        rvFavouriteMovies = view.findViewById(R.id.rvFavourite);
        rvFavouriteTvShows = view.findViewById(R.id.rvFavourite2);
        rvFavouriteMovies.setHasFixedSize(true);
        rvFavouriteMovies.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvFavouriteTvShows.setHasFixedSize(true);
        rvFavouriteTvShows.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        databaseHelperMovie = new DatabaseHelperMovie(requireContext());
        favouriteMovies = new ArrayList<>();
        favouriteMovieAdapter = new FavouriteMovieAdapter(favouriteMovies);
        rvFavouriteMovies.setAdapter(favouriteMovieAdapter);

        databaseHelperTv = new DatabaseHelperTv(requireContext());
        favouriteTvShows = new ArrayList<>();
        favouriteTvAdapter = new FavouriteTvAdapter(favouriteTvShows);
        rvFavouriteTvShows.setAdapter(favouriteTvAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refreshData();
    }

    public void refreshData() {
        favouriteMovies.clear();
        favouriteMovies.addAll(databaseHelperMovie.getFavoriteMovies());
        favouriteMovieAdapter.notifyDataSetChanged();

        favouriteTvShows.clear();
        favouriteTvShows.addAll(databaseHelperTv.getFavoriteTvShows());
        favouriteTvAdapter.notifyDataSetChanged();

        // Hapus tampilan UI jika tidak ada data favorit pada film
        if (favouriteMovies.isEmpty()) {
            rvFavouriteMovies.setVisibility(View.GONE);
        } else {
            rvFavouriteMovies.setVisibility(View.VISIBLE);
        }

        // Hapus tampilan UI jika tidak ada data favorit pada acara TV
        if (favouriteTvShows.isEmpty()) {
            rvFavouriteTvShows.setVisibility(View.GONE);
        } else {
            rvFavouriteTvShows.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == DETAIL_ACTIVITY_REQUEST_CODE) {
            refreshData();
        }
    }

}

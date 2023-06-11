package com.example.h071211076_finalmobile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.h071211076_finalmobile.adapter.FavouriteMovieAdapter;
import com.example.h071211076_finalmobile.adapter.FavouriteTvAdapter;
import com.example.h071211076_finalmobile.database.DatabaseHelperMovie;
import com.example.h071211076_finalmobile.database.DatabaseHelperTv;
import com.example.h071211076_finalmobile.model.ModelMovie;
import com.example.h071211076_finalmobile.model.ModelTv;

import java.util.List;

public class FavouriteFragment extends Fragment {

    RecyclerView rvFavourite, rvFavourite2;
    DatabaseHelperMovie databaseHelperMovie;
    FavouriteMovieAdapter favouriteMovieAdapter;
    FavouriteTvAdapter favouriteTvAdapter;
    ImageView ivFavourite;
    TextView tvTitle, TvReleaseDate;
    DatabaseHelperTv databaseHelperTv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        rvFavourite = view.findViewById(R.id.rvFavourite);
        rvFavourite2 = view.findViewById(R.id.rvFavourite2);
        rvFavourite.setHasFixedSize(true);
        rvFavourite.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rvFavourite2.setHasFixedSize(true);
        rvFavourite2.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        databaseHelperMovie = new DatabaseHelperMovie(getActivity());
        List<ModelMovie> modelMovieList = databaseHelperMovie.getFavoriteMovies();
        favouriteMovieAdapter = new FavouriteMovieAdapter(modelMovieList, FavouriteFragment.this);
        rvFavourite.setAdapter(favouriteMovieAdapter);

        databaseHelperTv = new DatabaseHelperTv(getActivity());
        List<ModelTv> modelTvList = databaseHelperTv.getFavoriteTvShows();
        favouriteTvAdapter = new FavouriteTvAdapter(modelTvList, FavouriteFragment.this);
        rvFavourite2.setAdapter(favouriteTvAdapter);

        return view;
       }

}
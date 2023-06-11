package com.example.h071211076_finalmobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211076_finalmobile.FavouriteFragment;
import com.example.h071211076_finalmobile.MovieDetailActivity;
import com.example.h071211076_finalmobile.R;
import com.example.h071211076_finalmobile.model.ModelMovie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteMovieAdapter extends RecyclerView.Adapter<FavouriteMovieAdapter.ViewHolder> {
    private List<ModelMovie> modelMovieList;
    private Context context;

    public FavouriteMovieAdapter(List<ModelMovie> modelMovieList) {
        this.modelMovieList = modelMovieList;
        this.context = context;
    }

    public FavouriteMovieAdapter(List<ModelMovie> favouriteMovies, FavouriteFragment favouriteFragment) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelMovie modelMovie = modelMovieList.get(position);
        String imageUrl = "https://image.tmdb.org/t/p/w500" + modelMovie.getPosterPath();
        Picasso.get().load(imageUrl).into(holder.ivMovie);
        holder.tvTitle.setText(modelMovie.getOriginalTitle());
        holder.tvReleaseDate.setText(modelMovie.getReleaseDate());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
            intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, modelMovie);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelMovieList.size();
    }

    public void updateData(List<ModelMovie> favouriteMovies) {
        modelMovieList = favouriteMovies;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMovie;
        TextView tvTitle, tvReleaseDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ivMovie = itemView.findViewById(R.id.ivMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvReleaseDate = itemView.findViewById(R.id.tvDate);
        }
    }
}

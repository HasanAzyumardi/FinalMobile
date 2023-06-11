package com.example.h071211076_finalmobile.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211076_finalmobile.FavouriteFragment;
import com.example.h071211076_finalmobile.MovieDetailActivity;
import com.example.h071211076_finalmobile.MovieFragment;
import com.example.h071211076_finalmobile.R;
import com.example.h071211076_finalmobile.model.ModelMovie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteMovieAdapter extends RecyclerView.Adapter<FavouriteMovieAdapter.ViewHolder> {
    private List<ModelMovie> modelMovieList;

    public FavouriteMovieAdapter(List<ModelMovie> modelMovieList, FavouriteFragment favouriteFragment) {
        this.modelMovieList = modelMovieList;
    }

    @Override
    public FavouriteMovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, parent, false);
        return new FavouriteMovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavouriteMovieAdapter.ViewHolder holder, int position) {
        ModelMovie modelMovie = modelMovieList.get(position);
        String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500" + modelMovieList.get(position).getPosterPath();
        Picasso.get().load(IMAGE_BASE_URL).into(holder.ivMovie);
        holder.tvTitle.setText(modelMovie.getOriginalTitle());
        holder.tvReleaseDate.setText(modelMovie.getReleaseDate());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
            intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, modelMovie);
            view.getContext().startActivity(intent);
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, modelMovie);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelMovieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clMovie;
        ImageView ivMovie;
        TextView tvTitle, tvReleaseDate;
        public ViewHolder(View itemView) {
            super(itemView);
            clMovie = itemView.findViewById(R.id.listmovie);
            ivMovie = itemView.findViewById(R.id.ivMovie);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvReleaseDate = itemView.findViewById(R.id.tvDate);
        }
    }
}

package com.example.h071211076_finalmobile.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211076_finalmobile.FavouriteFragment;
import com.example.h071211076_finalmobile.MovieDetailActivity;
import com.example.h071211076_finalmobile.R;
import com.example.h071211076_finalmobile.TvDetailActivity;
import com.example.h071211076_finalmobile.model.ModelTv;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteTvAdapter extends RecyclerView.Adapter<FavouriteTvAdapter.ViewHolder>{
    private List<ModelTv> modelTvList;

    public FavouriteTvAdapter(List<ModelTv> modelTvList, FavouriteFragment favouriteFragment) {
        this.modelTvList = modelTvList;
    }

    @Override
    public FavouriteTvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tv, parent, false);
        return new FavouriteTvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FavouriteTvAdapter.ViewHolder holder, int position) {
        ModelTv modelTv = modelTvList.get(position);
        String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500" + modelTvList.get(position).getPosterPath();
        Picasso.get().load(IMAGE_BASE_URL).into(holder.ivTv);
        holder.tvTitle.setText(modelTv.getOriginalName());
        holder.tvReleaseDate.setText(modelTv.getFirstAirDate());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), TvDetailActivity.class);
            intent.putExtra(TvDetailActivity.EXTRA_TV, modelTv);
            view.getContext().startActivity(intent);
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), TvDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, modelTv);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelTvList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout clTv;
        ImageView ivTv;
        TextView tvTitle, tvReleaseDate;
        public ViewHolder(View itemView) {
            super(itemView);
            clTv = itemView.findViewById(R.id.listTv);
            ivTv = itemView.findViewById(R.id.ivTv);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvReleaseDate = itemView.findViewById(R.id.tvDate);
        }
    }

}

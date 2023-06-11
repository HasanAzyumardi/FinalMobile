package com.example.h071211076_finalmobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.h071211076_finalmobile.FavouriteFragment;
import com.example.h071211076_finalmobile.R;
import com.example.h071211076_finalmobile.TvDetailActivity;
import com.example.h071211076_finalmobile.model.ModelTv;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteTvAdapter extends RecyclerView.Adapter<FavouriteTvAdapter.ViewHolder> {
    private List<ModelTv> modelTvList;
    private FavouriteFragment favouriteFragment;

    Context context;

    public FavouriteTvAdapter(List<ModelTv> modelTvList) {
        this.modelTvList = modelTvList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelTv modelTv = modelTvList.get(position);
        String imageUrl = "https://image.tmdb.org/t/p/w500" + modelTv.getPosterPath();
        Picasso.get().load(imageUrl).into(holder.ivTv);
        holder.tvTitle.setText(modelTv.getOriginalName());
        holder.tvReleaseDate.setText(modelTv.getFirstAirDate());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), TvDetailActivity.class);
            intent.putExtra(TvDetailActivity.EXTRA_TV, modelTv);
            view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelTvList.size();
    }

    public void updateData(List<ModelTv> favouriteTvShows) {
        modelTvList = favouriteTvShows;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivTv;
        TextView tvTitle, tvReleaseDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTv = itemView.findViewById(R.id.ivTv);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvReleaseDate = itemView.findViewById(R.id.tvDate);
        }
    }
}

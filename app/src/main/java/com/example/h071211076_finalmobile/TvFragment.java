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

import com.example.h071211076_finalmobile.adapter.TvAdapter;
import com.example.h071211076_finalmobile.model.ModelTv;
import com.example.h071211076_finalmobile.response.TvResponse;
import com.example.h071211076_finalmobile.utility.MoviedbConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvFragment extends Fragment {

    RecyclerView rvTv;
    TvAdapter tvAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv, container, false);

        rvTv = view.findViewById(R.id.rvTv);
        rvTv.setHasFixedSize(true);
        rvTv.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MoviedbConfig.getMoviedbAPI().getPopularTv().enqueue(new Callback<TvResponse>() {
            @Override
            public void onResponse(Call<TvResponse> call, Response<TvResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<ModelTv> modelTvList = response.body().getResults();
                    tvAdapter = new TvAdapter(modelTvList, TvFragment.this);
                    rvTv.setAdapter(tvAdapter);
                }
            }

            @Override
            public void onFailure(Call<TvResponse> call, Throwable t) {
                // Handle failure
            }
        });
    }
}

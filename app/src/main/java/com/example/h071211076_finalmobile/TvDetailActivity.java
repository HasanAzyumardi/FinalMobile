package com.example.h071211076_finalmobile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.h071211076_finalmobile.database.DatabaseHelperTv;
import com.example.h071211076_finalmobile.model.ModelTv;
import com.squareup.picasso.Picasso;

public class  TvDetailActivity extends AppCompatActivity {
    public static final String EXTRA_TV = "extra_tv";
    private ImageView btn_backTv, backPoster, poster, ivFavourite, ivDelete;
    private TextView tittleDetailTv, releaseDateDetailTv, textViewRating, TvDescDetail, tvOverviewDetail;

    private boolean isFavorite;

    public static final String IMAGE_URL_BASE_PATH = "https://image.tmdb.org/t/p/w500";

    private DatabaseHelperTv databaseHelper;

    private String title, overview, releaseDate, posterPath, backdropPath, voteAverage;
    private ModelTv modelTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tv);

        btn_backTv = findViewById(R.id.btnBack);
        tittleDetailTv = findViewById(R.id.titleTv);
        releaseDateDetailTv = findViewById(R.id.releaseDateTv);
        textViewRating = findViewById(R.id.tvRating);
        TvDescDetail = findViewById(R.id.DescTv);
        tvOverviewDetail = findViewById(R.id.DescDetailTv);
        backPoster = findViewById(R.id.backPoster);
        poster = findViewById(R.id.poster);
        ivFavourite = findViewById(R.id.btnLove);

        btn_backTv.setOnClickListener(view -> {
            finish();
        });

        databaseHelper = new DatabaseHelperTv(this);

        modelTv = getIntent().getParcelableExtra(EXTRA_TV);

        if (modelTv != null) {
            title = modelTv.getOriginalName();
            overview = modelTv.getOverview();
            releaseDate = modelTv.getFirstAirDate();
            posterPath = modelTv.getPosterPath();
            backdropPath = modelTv.getBackdropPath();
            voteAverage = modelTv.getVoteAverage().toString();

            textViewRating.setText(voteAverage);
            tittleDetailTv.setText(title);
            releaseDateDetailTv.setText(releaseDate);
            tvOverviewDetail.setText(overview);

            Picasso.get()
                    .load(IMAGE_URL_BASE_PATH + posterPath)
                    .into(poster);
            Picasso.get()
                    .load(IMAGE_URL_BASE_PATH + backdropPath)
                    .into(backPoster);

            isFavorite = databaseHelper.isTvShowFavorite(modelTv.getId());
            updateFavoriteButton();

            ivFavourite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toggleFavorite();
                }
            });
        }
    }

    private void toggleFavorite() {
        if (isFavorite) {
            databaseHelper.removeTvShowFromFavorites(modelTv.getId());
            Toast.makeText(this, "Removed from favorites", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.addTvShowToFavorites(modelTv);
            Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show();
        }

        isFavorite = !isFavorite;
        updateFavoriteButton();
    }

    private void updateFavoriteButton() {
        if (isFavorite) {
            ivFavourite.setImageResource(R.drawable.loved);
        } else {
            ivFavourite.setImageResource(R.drawable.love);
        }
    }
}

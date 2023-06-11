package com.example.h071211076_finalmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.h071211076_finalmobile.MainActivity;
import com.example.h071211076_finalmobile.R;
import com.example.h071211076_finalmobile.database.DatabaseHelperMovie;
import com.squareup.picasso.Picasso;

import com.example.h071211076_finalmobile.model.ModelMovie;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    private ImageView btn_backMovie, backPoster, poster, ivFavourite;
    private TextView tittleDetailMovie, releaseDateDetailMovie, ratingMovie, textViewRating, MovieDescDetail, tvOverviewDetail;

    public static final String IMAGE_URL_BASE_PATH = "https://image.tmdb.org/t/p/w500";

    private String title, overview, releaseDate, posterPath, backdropPath, voteAverage;
    private boolean isFavorite;
    private DatabaseHelperMovie databaseHelper;
    private ModelMovie modelMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movies);

        btn_backMovie = findViewById(R.id.btnBack);
        tittleDetailMovie = findViewById(R.id.titleMovie);
        releaseDateDetailMovie = findViewById(R.id.releaseDateMovie);
        textViewRating = findViewById(R.id.tvRating);
        MovieDescDetail = findViewById(R.id.DescMovie);
        tvOverviewDetail = findViewById(R.id.DescDetailMovie);
        backPoster = findViewById(R.id.backPoster);
        poster = findViewById(R.id.poster);
        ivFavourite = findViewById(R.id.ivFavorite);

        btn_backMovie.setOnClickListener(view -> {
            finish();
        });

        databaseHelper = new DatabaseHelperMovie(this);

        modelMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        if (modelMovie != null) {
            title = modelMovie.getOriginalTitle();
            overview = modelMovie.getOverview();
            releaseDate = modelMovie.getReleaseDate();
            posterPath = modelMovie.getPosterPath();
            backdropPath = modelMovie.getBackdropPath();
            voteAverage = modelMovie.getVoteAverage().toString();

            textViewRating.setText(voteAverage);
            tittleDetailMovie.setText(title);
            releaseDateDetailMovie.setText(releaseDate);
            tvOverviewDetail.setText(overview);

            Picasso.get()
                    .load(IMAGE_URL_BASE_PATH + posterPath)
                    .into(poster);
            Picasso.get()
                    .load(IMAGE_URL_BASE_PATH + backdropPath)
                    .into(backPoster);

            isFavorite = databaseHelper.isMovieFavorite(modelMovie.getId());
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
            databaseHelper.removeMovieFromFavorites(modelMovie.getId());
            Toast.makeText(this, "Removed from favorites", Toast.LENGTH_SHORT).show();
        } else {
            databaseHelper.addMovieToFavorites(modelMovie);
            Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show();
        }

        isFavorite = !isFavorite;

        // Check if isFavorite is false after toggling
        if (!isFavorite) {
            // Perform the deletion operation
            deleteMovie();
        }

        updateFavoriteButton();
    }

    private void deleteMovie() {
        boolean deleted = databaseHelper.deleteMovie(modelMovie.getId());
        if (deleted) {
            Toast.makeText(this, "Movie deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to delete movie", Toast.LENGTH_SHORT).show();
        }
    }


    private void updateFavoriteButton() {
        if (isFavorite) {
            ivFavourite.setImageResource(R.drawable.loved);
        } else {
            ivFavourite.setImageResource(R.drawable.love);
        }
    }
}

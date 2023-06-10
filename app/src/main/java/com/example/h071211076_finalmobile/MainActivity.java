package com.example.h071211076_finalmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ImageView movie, tv, favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movie = findViewById(R.id.moviesbtn);
        tv = findViewById(R.id.tvbtn);
        favorite = findViewById(R.id.lovebtn);

        FragmentManager fragmentManager = getSupportFragmentManager();
        MovieFragment movieFragment = new MovieFragment();
        TvFragment tvFragment = new TvFragment();
       switchFragment(movieFragment);
       tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               switchFragment(tvFragment);
           }
       }       );
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment(movieFragment);
            }
        }       );

    }
        public void switchFragment(Fragment fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction
                    .replace(R.id.frame_layout, fragment,
                            MovieFragment.class.getSimpleName())
                    .commit();
        }

}

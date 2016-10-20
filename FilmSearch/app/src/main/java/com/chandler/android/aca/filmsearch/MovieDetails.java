package com.chandler.android.aca.filmsearch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {

    private TextView mMovieTitle;
    private TextView mMovieDescription;
    private ImageView mImageView;
    private Button mBackButton;

    private MoviesAdapter mAdapter;
    Movie movie = new Movie();
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        //mAdapter = new MoviesAdapter(this);
        //mAdapter.getMovieList();

        mMovieTitle = (TextView) findViewById(R.id.movieTitle);
        mMovieDescription = (TextView) findViewById(R.id.movieDescription);
        mImageView = (ImageView) findViewById(R.id.backdropImage);
        mBackButton = (Button) findViewById(R.id.btnBack);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        /*String title;
        String backdrop;
        String description;


        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle == null) {
                mMovieTitle.setText("failed");
                backdrop = null;
                description = null;
            } else {
                title = movie.getMovieTitle();
                backdrop = movie.getBackdrop();
                description = movie.getDescription();

                Picasso.with(mContext)
                        .load(movie.getBackdrop())
                        .placeholder(R.color.colorAccent)
                        .into(mImageView);

                mMovieTitle.setText(title);
                mMovieDescription.setText(description);
            }
        }*/

        Intent intent = getIntent();
        intent.getSerializableExtra("Movie");

        Movie movie = (Movie) intent.getSerializableExtra("Movie");

        mMovieTitle.setText(movie.getMovieTitle());
        mMovieDescription.setText(movie.getDescription());

        Picasso.with(mContext)
                .load(movie.getBackdrop())
                .placeholder(R.color.colorAccent)
                .into(mImageView);

    }
}

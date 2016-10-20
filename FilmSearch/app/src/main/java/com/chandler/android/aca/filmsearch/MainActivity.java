package com.chandler.android.aca.filmsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView; //get a reference
    private MoviesAdapter mAdapter;
    private Movie mMovie; //added this for the lab assgn


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView); //link the reference to the view

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //two side by side
        mAdapter = new MoviesAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        final List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            movies.add(new Movie());
        }
        mAdapter.setMovieList(movies);
        //allow the adapter and the recyclerview to communicate

        myRetrofit();

        mRecyclerView.addOnItemTouchListener(new RecyclerOnClick(getApplicationContext(),
                mRecyclerView, new RecyclerOnClick.OnItemClickListener() {

                @Override
                public void onItemClick(View v, int position) {

                    int itemPosition = mRecyclerView.getChildLayoutPosition(v);
                    mAdapter.getMovieList();
                    Movie selected = movies.get(itemPosition);

                    final String mBackdrop = selected.getBackdrop();
                    final String mTitle = selected.getMovieTitle();
                    final String mDescription = selected.getDescription();

                    /*final String mBackdrop = mMovie.getBackdrop();
                    final String mTitle = mMovie.getTitle();
                    final String mDescription = mMovie.getDescription();*/

                    Intent intent = new Intent(getApplicationContext(), MovieDetails.class);
                    intent.putExtra("Movie", mAdapter.getMovieList().get(position));

                    /*Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                    intent.putExtra("BACK", mBackdrop);
                    intent.putExtra("TITLE", mTitle);
                    intent.putExtra("DESC", mDescription);*/

                    startActivity(intent);
                }

                @Override
                public void onLongItemClick(View view, int position) {

                }

            })
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void myRetrofit(){
        Retrofit restAdapter = new Retrofit.Builder() //create a retrofit object (rest adapter)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.themoviedb.org/")
                .build();

        MoviesApiService apiService = restAdapter.create(MoviesApiService.class);

        Call<Movie.MovieResult> call = apiService.getPopularMovies();
        call.enqueue(new Callback<Movie.MovieResult>() {
            @Override
            public void onResponse(Call<Movie.MovieResult> call, Response<Movie.MovieResult> response) {
                mAdapter.setMovieList(response.body().getResults());
            }

            @Override
            public void onFailure(Call<Movie.MovieResult> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

}


       /* mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                int itemPosition = mRecyclerView.getChildLayoutPosition(rv);
                mAdapter.getMovieList();
                Movie selected = movies.get(itemPosition);

                final String mBackdrop = mMovie.getBackdrop();
                final String mTitle = mMovie.getTitle();
                final String mDescription = mMovie.getDescription();

                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("BACK", mBackdrop);
                intent.putExtra("TITLE", mTitle);
                intent.putExtra("DESC", mDescription);

                startActivity(intent);
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }*/


      /*  new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int itemPosition = mRecyclerView.getChildLayoutPosition(v);
                mAdapter.getMovieList();
                Movie selected = movies.get(itemPosition);

                final String mBackdrop = mMovie.getBackdrop();
                final String mTitle = mMovie.getTitle();
                final String mDescription = mMovie.getDescription();

                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("BACK", mBackdrop);
                intent.putExtra("TITLE", mTitle);
                intent.putExtra("DESC", mDescription);

                startActivity(intent);
            }
        };*/

   /* public final View.OnClickListener ClickityClack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int itemPosition = mRecyclerView.getChildLayoutPosition(v);
            Movie item = movies.get(itemPosition);

            mAdapter.getMovieList();

            final String mBackdrop = mMovie.getBackdrop();
            final String mTitle = mMovie.getTitle();
            final String mDescription = mMovie.getDescription();

            Intent intent = new Intent(MainActivity.this, MovieDetails.class);
            intent.putExtra("BACK", mBackdrop);
            intent.putExtra("TITLE", mTitle);
            intent.putExtra("DESC", mDescription);

            startActivity(intent);
        }
    };*/
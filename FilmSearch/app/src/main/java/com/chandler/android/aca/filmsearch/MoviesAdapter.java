package com.chandler.android.aca.filmsearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> mMovieList;
    private LayoutInflater mInflater;
    private Context mContext;

    RecyclerView mRecyclerView;
    MoviesAdapter mAdapter;
    Movie mMovie;


    public MoviesAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMovieList = new ArrayList<>();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.row_movie, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        return viewHolder;

        //todo DEAL WITH THIS SHIT

    }

    @Override
    public void onBindViewHolder(final MovieViewHolder holder, int position) {
        Movie movie = mMovieList.get(position);

        // This is how we use Picasso to load images from the internet.
        Picasso.with(mContext)
                .load(movie.getPoster())
                .placeholder(R.color.colorAccent)
                .into(holder.imageView);

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = mRecyclerView.getChildAdapterPosition(v);
                //getChildViewHolder
                //findContainingItemView
                //findViewHolderForAdapterPosition
                mAdapter.getMovieList();
                holder.getAdapterPosition();

                String mBackdrop = mMovie.getBackdrop();
                String mTitle = mMovie.getTitle();
                String mDescription = mMovie.getDescription();

                Intent intent = new Intent(mContext, MovieDetails.class);
                intent.putExtra("BACK", mBackdrop);
                intent.putExtra("TITLE", mTitle);
                intent.putExtra("DESC", mDescription);

                mContext.startActivity(intent);
            } //This seemed like a good plan with the original goal of setting onClick to the holder
            //But I don't know how to make it work yet
        });*/
    }

    @Override
    public int getItemCount() {
        return (mMovieList == null) ? 0 : mMovieList.size();
    } //this does the same thing as an if/else statement
    //if movie list = null, return 0, if not null, return movielist.size


    public void setMovieList(List<Movie> movieList) {
        this.mMovieList.clear(); //clearing movie list to start fresh
        this.mMovieList.addAll(movieList);
        // The adapter needs to know that the data has changed.
        // If we don't call this, app will crash.
        notifyDataSetChanged();
    }

    public List<Movie> getMovieList() {
        return mMovieList; //needed because the other list is empty
    }


}



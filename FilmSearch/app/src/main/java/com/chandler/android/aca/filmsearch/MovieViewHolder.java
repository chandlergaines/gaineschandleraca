package com.chandler.android.aca.filmsearch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public MovieViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }
}

//this class is a view holder that will fill in the recyclerview
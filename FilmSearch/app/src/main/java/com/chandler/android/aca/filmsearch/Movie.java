package com.chandler.android.aca.filmsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    public static final String TMDB_IMAGE_PATH = "http://image.tmdb.org/t/p/w500";
    //picasso needs the full url of the image so we add this bit in so when we get the url of the
    //image we only get the unique bit for each image, we need the full thing, so we hardcode this in

    private String mTitle;

    @SerializedName("poster_path") //this is to tell the Gson which JSON matches this field
    private String mPoster;

    @SerializedName("overview") //this address for this image will be matched up with this JSON object
    private String mDescription;

    @SerializedName("backdrop_path") //serialized name allows us to name our object whatever we want
    private String mBackdrop;

    public Movie() {}

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getPoster() {
        return TMDB_IMAGE_PATH + mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getBackdrop() {
        return TMDB_IMAGE_PATH  + mBackdrop;
    }

    public void setBackdrop(String backdrop) {
        mBackdrop = backdrop;
    }

    public static class MovieResult {
        private List<Movie> results;

        public List<Movie> getResults() {
            return results;
        }
    } //this pojo matches the the structure of the response
    // we are getting back from the api
}

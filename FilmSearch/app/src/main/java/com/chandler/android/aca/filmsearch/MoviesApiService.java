package com.chandler.android.aca.filmsearch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApiService {

    @GET("/3/movie/popular?api_key=0fae65ab038cffbd876eaa0cd3d844d6")
    Call<Movie.MovieResult> getPopularMovies();
}

//this interacts with the api and uses your key for access

    /*We’ve created a new Java interface that will represent our API (TMDB API).

    Each method of this interface corresponds to an endpoint of our REST
    API. We need to annotate our methods to let retrofit know two things:
    what kind of request the method executes, and what endpoint it must
    connect to.

    Retrofit allows you to make @POST, @UPDATE,@PATCH, @DELETE, and @GET
    requests. Notice that we’re only including the part of the TMDB Url that
    changes from endpoint to endpoint. The rest, we will tell retrofit
    at the time of initialization.*/
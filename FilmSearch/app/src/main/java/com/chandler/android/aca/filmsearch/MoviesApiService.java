package com.chandler.android.aca.filmsearch;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApiService {

    @GET("/3/movie/popular?api_key=0fae65ab038cffbd876eaa0cd3d844d6")
    Call<Movie.MovieResult> getPopularMovies();
}

package com.rsiyun.catalogmovie.rest;

import retrofit2.Call;
import com.rsiyun.catalogmovie.model.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/3/movie/{category}")
    Call<Response> getMovie(
            @Path("category") String category,
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("page") int page
    );
//    https://api.themoviedb.org/3/search/movie?api_key=307fefa4d0e995ba8f8071551c7a82a8&language=en-US&page=1&include_adult=false?
    @GET("/3/search/movie")
    Call<Response> getQuery(
            @Query("api_key") String api_key,
            @Query("language") String language,
            @Query("query") String query,
            @Query("page") int page
    );
}

package com.example.server;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Pixel {

    //https://newsapi.org/v2/everything?q=keyword&apiKey=1a2eff30cb1b4b6aa71508a6dbd5eee6

    @GET("/v2/everything")
    Call<NewsModel> getData(@Query("q") String resourceName, @Query("apiKey") String count);
}

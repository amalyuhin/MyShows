package com.amalyuhin.myshows.api;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by amalyuhin on 01.12.2014.
 */
public interface ApiService {

    @GET("/profile/login")
    public Observable<Response> login(@Query("login") String login, @Query("password") String password);

}

package com.amalyuhin.myshows.api;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by amalyuhin on 01.12.2014.
 */
public interface ApiService {

    @GET("/profile/login")
    public void login(@Field("login") String login, @Field("password") String password, Callback<Response> callback);


}

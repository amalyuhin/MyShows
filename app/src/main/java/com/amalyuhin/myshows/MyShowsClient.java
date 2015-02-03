package com.amalyuhin.myshows;

import com.amalyuhin.myshows.api.ApiService;

import retrofit.RestAdapter;

/**
 * Created by amalyuhin on 26.01.2015.
 */
public class MyShowsClient {

    private static final String BASE_URL = "http://api.myshows.ru";
    private static ApiService apiService;

    public static ApiService getApiService() {
        if (null == apiService) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(BASE_URL)
                    .build();

            apiService = restAdapter.create(ApiService.class);
        }

        return apiService;
    }

}

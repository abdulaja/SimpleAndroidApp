package com.asiscode.simpleandroidapps.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by muhammad.azis on 21/03/2018.
 */

public class APIInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://192.168.90.17:8080/rest-api/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}

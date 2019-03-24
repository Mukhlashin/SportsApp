package com.example.sportsapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static String url = "https://www.thesportsdb.com/api/v1/json/1/";

    public static Retrofit setInit1() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit setInit2() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit setInit3() {
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIService getInstance1() {
        return setInit1().create(APIService.class);
    }

    public static APIService getInstance2() {
        return setInit2().create(APIService.class);
    }

    public static APIService getInstance3() {
        return setInit3().create(APIService.class);
    }

}

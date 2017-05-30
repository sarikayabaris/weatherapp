package com.mobsmile.weatherapp.network;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This file created by barissarikaya on 5/29/17.
 */

public class NetworkHelper {
    private static OkHttpClient client;
    private static Retrofit retrofit;
    private static final String MAIN_DOMAIN = "http://api.openweathermap.org";

    public static Retrofit getRetroFit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(MAIN_DOMAIN)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(getOkHttpClient())
                    .build();
        }
        return retrofit;
    }

    public API getAPI() {
        return getRetroFit().create(API.class);
    }

    public static OkHttpClient getOkHttpClient() {
        if (client == null) {
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            clientBuilder.addInterceptor(chain -> chain.proceed(chain.request()));
            clientBuilder.readTimeout(15, TimeUnit.SECONDS);
            clientBuilder.connectTimeout(30, TimeUnit.SECONDS);
            clientBuilder.addNetworkInterceptor(getHeaderInterceptor());
            client = clientBuilder.build();
        }
        return client;
    }

    private static Interceptor getHeaderInterceptor() {
        return chain -> {
            Request.Builder builder = chain.request().newBuilder();

            builder.addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json");

            return chain.proceed(builder.build());
        };
    }
}

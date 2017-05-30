package com.mobsmile.weatherapp.network;

import com.mobsmile.weatherapp.ForecastResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * This file created by barissarikaya on 5/29/17.
 */

public interface API {

    @GET("/data/2.5/forecast")
    Observable<ForecastResponse> getForecastById(@Query("id") int id, @Query("appid") String appId);
}

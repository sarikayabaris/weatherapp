package com.mobsmile.weatherapp.network;

import com.mobsmile.weatherapp.model.ForecastResponse;

import rx.Observable;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class NetworkManager {
    private final String APP_ID = "53b12e8a5ac738ff5ad13a5895d06b0c";
    private API api;

    public NetworkManager() {
        this(new NetworkHelper().getAPI());
    }

    public NetworkManager(API api) {
        this.api = api;
    }

    public Observable<ForecastResponse> getForecastById(int id) {
        return api.getForecastById(id, APP_ID);
    }
}


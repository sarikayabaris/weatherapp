package com.mobsmile.weatherapp;

import com.mobsmile.weatherapp.network.NetworkManager;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class HomeCaller extends Caller<ForecastResponse> {
    public HomeCaller(NetworkManager networkManager, int id) {
        super(() -> networkManager.getForecastById(id));
    }
}

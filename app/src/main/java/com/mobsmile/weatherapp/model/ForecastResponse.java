package com.mobsmile.weatherapp.model;

import com.google.gson.annotations.SerializedName;
import com.mobsmile.weatherapp.model.City;
import com.mobsmile.weatherapp.model.Forecast;

import java.util.List;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class ForecastResponse {
    @SerializedName("list")
    private List<Forecast> forecasts;
    @SerializedName("city")
    private City city;

    public ForecastResponse(List<Forecast> forecasts, City city) {
        this.forecasts = forecasts;
        this.city = city;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public City getCity() {
        return city;
    }
}

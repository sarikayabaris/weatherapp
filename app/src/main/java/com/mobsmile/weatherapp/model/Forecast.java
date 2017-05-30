package com.mobsmile.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class Forecast {
    @SerializedName("dt")
    private long id;
    @SerializedName("dt_txt")
    private String date;
    @SerializedName("main")
    private Main main;
    @SerializedName("weather")
    private List<Weather> weathers;

    public Forecast(long id, String date, Main main, List<Weather> weathers) {
        this.id = id;
        this.date = date;
        this.main = main;
        this.weathers = weathers;
    }

    public long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }
}

package com.mobsmile.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class Weather {
    private final String ICON_URL = "http://openweathermap.org/img/w/";
    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public Weather(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconUrl() {
        return ICON_URL + icon + ".png";
    }
}

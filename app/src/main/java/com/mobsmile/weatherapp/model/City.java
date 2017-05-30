package com.mobsmile.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class City {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;

    public City(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}

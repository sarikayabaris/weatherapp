package com.mobsmile.weatherapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class Main {
    private final double difference = 273.15;
    @SerializedName("temp")
    private double temp;
    @SerializedName("temp_min")
    private double tempMin;
    @SerializedName("temp_max")
    private double tempMax;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("humidity")
    private int humidity;

    public Main(double temp, double tempMin, double tempMax, double pressure, int humidity) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public int getTemp() {
        return (int) (temp - difference);
    }

    public double getTempMin() {
        return tempMin - difference;
    }

    public double getTempMax() {
        return tempMax - difference;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}

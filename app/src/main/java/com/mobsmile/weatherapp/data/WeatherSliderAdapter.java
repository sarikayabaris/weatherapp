package com.mobsmile.weatherapp.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobsmile.weatherapp.R;
import com.mobsmile.weatherapp.model.Forecast;

import butterknife.ButterKnife;
import rx.subjects.PublishSubject;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class WeatherSliderAdapter extends ClickableAdapter<Forecast, WeatherSliderViewHolder> {
    @Override
    protected WeatherSliderViewHolder onCreateViewHolder(ViewGroup parent, int viewType, PublishSubject<Forecast> itemClickedSubject) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_slider_item, parent, false);
        WeatherSliderViewHolder viewHolder = new WeatherSliderViewHolder(itemView, itemClickedSubject);
        ButterKnife.bind(viewHolder, itemView);
        return viewHolder;
    }
}

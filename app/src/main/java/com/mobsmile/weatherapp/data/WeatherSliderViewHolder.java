package com.mobsmile.weatherapp.data;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mobsmile.weatherapp.R;
import com.mobsmile.weatherapp.model.Forecast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import rx.subjects.PublishSubject;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class WeatherSliderViewHolder extends ClickableViewHolder<Forecast> {
    @BindView(R.id.slider_icon)
    ImageView sliderIcon;
    @BindView(R.id.slider_date)
    TextView sliderDate;
    @BindView(R.id.slider_temp)
    TextView sliderTemp;
    private Context context;

    public WeatherSliderViewHolder(View itemView, PublishSubject<Forecast> itemClickedSubject) {
        super(itemView, itemClickedSubject);
        context = itemView.getContext();
    }

    @Override
    protected void bind(Forecast forecast) {
        sliderDate.setText(getFormattedDate(forecast.getDate()));
        sliderTemp.setText(forecast.getMain().getTemp() + " \u2103");
        Glide.with(context).load(forecast.getWeathers().get(0).getIconUrl())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(sliderIcon);
    }

    private String getFormattedDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = format.parse(dateString);
            format = new SimpleDateFormat("dd/MM HH:mm");
            return format.format(date);
        } catch (ParseException e) {
        }
        return null;
    }

}

package com.mobsmile.weatherapp;

import com.mobsmile.weatherapp.model.Forecast;

import java.util.List;

import rx.Observable;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class HomePresenter extends Presenter<HomePresenter.View> {

    private HomeCaller homeCaller;

    public HomePresenter(HomeCaller homeCaller) {
        this.homeCaller = homeCaller;
    }

    @Override
    protected void onViewAttached(HomePresenter.View view) {
        super.onViewAttached(view);

        addSubscription(homeCaller.observeLoading().subscribe(view::showLoading));
        addSubscription(homeCaller.observeErrors().subscribe(view::showError));
        addSubscription(homeCaller.observeData().subscribe(response -> {
            view.displayForecasts(response.getForecasts());
            view.updateCityName(response);
        }));

        addSubscription(view.onSliderItemClicked().subscribe(view::updateTopDetailScreen));
    }

    public interface View extends Presenter.View {

        Observable<Forecast> onSliderItemClicked();

        void showLoading(boolean show);

        void showError(String error);

        void displayForecasts(List<Forecast> forecasts);

        void updateTopDetailScreen(Forecast forecast);

        void updateCityName(ForecastResponse response);
    }
}

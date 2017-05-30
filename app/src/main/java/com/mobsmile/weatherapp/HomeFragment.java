package com.mobsmile.weatherapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsmile.weatherapp.data.WeatherSliderAdapter;
import com.mobsmile.weatherapp.model.Forecast;
import com.mobsmile.weatherapp.network.NetworkManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class HomeFragment extends Fragment implements HomePresenter.View {
    private final int LONDON_ID = 2643743;
    private HomePresenter presenter = new HomePresenter(new HomeCaller(new NetworkManager(), LONDON_ID));
    @BindView(R.id.slider_recycler_view)
    public RecyclerView recyclerView;
    @BindView(R.id.main_city_name)
    public TextView mainName;
    @BindView(R.id.main_city_temp)
    public TextView mainTemp;
    @BindView(R.id.progress_bar)
    public ProgressBar progressBar;
    private WeatherSliderAdapter adapter = new WeatherSliderAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        presenter.attach(this);
        return view;
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public Observable<Forecast> onSliderItemClicked() {
        return adapter.observeItemClicks();
    }

    @Override
    public void displayForecasts(List<Forecast> forecasts) {
        adapter.setItems(forecasts);
    }

    @Override
    public void updateTopDetailScreen(Forecast forecast) {
        mainTemp.setText(String.valueOf(forecast.getMain().getTemp()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detach(this);
    }

    @Override
    public void showLoading(boolean show) {
        progressBar.setVisibility(show ? VISIBLE : INVISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateCityName(ForecastResponse response) {
        mainName.setText(response.getCity().getName() + ", " + response.getCity().getCountry());
        mainTemp.setText(String.valueOf(response.getForecasts().get(0).getMain().getTemp()));
    }
}

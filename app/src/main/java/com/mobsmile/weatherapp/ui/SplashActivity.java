package com.mobsmile.weatherapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.mobsmile.weatherapp.R;

import butterknife.ButterKnife;


public class SplashActivity extends AppCompatActivity {

    private static final Integer SPLASH_SCREEN_SHOW_PERIOD = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        final Handler handler = new Handler();
        handler.postDelayed(this::executeAfterSplashScreen, SPLASH_SCREEN_SHOW_PERIOD);
    }

    protected void goToHomeActivity() {
        Intent myIntent = new Intent(this, HomeActivity.class);
        this.startActivity(myIntent);
        finish();
    }

    private void executeAfterSplashScreen() {
        if (!isFinishing()) {
            goToHomeActivity();
        }
    }
}

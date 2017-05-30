package com.mobsmile.weatherapp.ui;

import android.os.Bundle;

/**
 * This file created by barissarikaya on 5/29/17.
 */
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            replaceFragment(new HomeFragment());
        }
    }
}

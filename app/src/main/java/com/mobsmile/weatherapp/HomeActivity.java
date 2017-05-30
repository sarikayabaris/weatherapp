package com.mobsmile.weatherapp;

import android.app.Fragment;
import android.os.Bundle;
/**
 * This file created by barissarikaya on 5/29/17.
 */
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if (null == savedInstanceState) {
            Fragment fragment = getFragmentManager().findFragmentByTag(HomeFragment.class.getName());
            if (null == fragment)
                fragment = new HomeFragment();
            replaceFragment(fragment);
        }
    }
}

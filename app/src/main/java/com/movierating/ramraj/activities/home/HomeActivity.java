package com.movierating.ramraj.activities.home;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.movierating.ramraj.R;
import com.movierating.ramraj.adapter.VerticalPagerAdapter;
import com.movierating.ramraj.ext.ui.CustomViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramraj on 4/24/17.
 */

public class HomeActivity extends AppCompatActivity {

    private PagerAdapter pagerAdapter;
    private final String TAG = HomeActivity.class.getSimpleName();

    @BindView(R.id.view_pager)
    CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        pagerAdapter = new VerticalPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

    }

}

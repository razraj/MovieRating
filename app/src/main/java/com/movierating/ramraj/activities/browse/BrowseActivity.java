package com.movierating.ramraj.activities.browse;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.widget.EditText;

import com.movierating.ramraj.R;
import com.movierating.ramraj.adapter.SliderPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import rx.Observable;

public class BrowseActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private SliderPagerAdapter pagerAdapter;
    private Observable<String> observable;

    @BindView(R.id.search)
    EditText searchet;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        ButterKnife.bind(this);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pagerAdapter = new SliderPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                searchet.setText("");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnTextChanged(R.id.search)
    void onSearchTextChange(CharSequence value) {
        ((BrowseFragment) (pagerAdapter.getItem(viewPager.getCurrentItem()))).setSearchString(value.toString());
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

package com.movierating.ramraj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.movierating.ramraj.activities.browse.BrowseFragment;

/**
 * Created by ramraj on 4/25/17.
 */

public class SliderPagerAdapter extends FragmentStatePagerAdapter {

    private BrowseFragment browseFragment1 = BrowseFragment.newInstance("movies");
    private BrowseFragment browseFragment2 = BrowseFragment.newInstance("tvSeries");

    public SliderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return browseFragment1;
            case 1:
                return browseFragment2;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Movies";
            case 1:
                return "Tv Series";
        }
        return null;
    }
}

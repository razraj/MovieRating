package com.movierating.ramraj.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.movierating.ramraj.activities.home.BrowseViewFragment;
import com.movierating.ramraj.activities.home.SearchViewFragment;

/**
 * Created by ramraj on 4/26/17.
 */

public class VerticalPagerAdapter extends FragmentStatePagerAdapter {

    private SearchViewFragment searchViewFragment = new SearchViewFragment();
    private BrowseViewFragment browseViewFragment = new BrowseViewFragment();

    public VerticalPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return searchViewFragment;
            case 1:
                return browseViewFragment;
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

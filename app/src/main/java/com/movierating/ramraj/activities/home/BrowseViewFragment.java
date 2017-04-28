package com.movierating.ramraj.activities.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movierating.ramraj.R;
import com.movierating.ramraj.activities.browse.BrowseActivity;
import com.movierating.ramraj.activities.browse.dagger.BrowseActivityModule;
import com.movierating.ramraj.activities.browse.dagger.DaggerBrowseComponent;
import com.movierating.ramraj.activities.search.SearchActivity;
import com.movierating.ramraj.app.CoreApplication;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ramraj on 4/26/17.
 */

public class BrowseViewFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.browse_view, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.browse)
    void onSearchClick() {
        Intent intent = new Intent(getContext(), BrowseActivity.class);
        startActivity(intent);
    }
}

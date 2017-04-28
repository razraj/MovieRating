package com.movierating.ramraj.activities.search;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.movierating.ramraj.activities.search.dagger.DaggerSearchComponent;
import com.movierating.ramraj.activities.search.dagger.SearchModule;
import com.movierating.ramraj.activities.search.mvp.SearchPresenter;
import com.movierating.ramraj.activities.search.mvp.view.SearchView;
import com.movierating.ramraj.app.CoreApplication;

import javax.inject.Inject;

public class SearchActivity extends AppCompatActivity {

    private final static String TAG = SearchActivity.class.getSimpleName();

    @Inject
    SearchView view;

    @Inject
    SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSearchComponent.builder()
                .appComponent(CoreApplication.get(this).component())
                .searchModule(new SearchModule(this))
                .build().inject(this);

        setContentView(view);
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}

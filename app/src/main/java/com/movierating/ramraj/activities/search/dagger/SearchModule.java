package com.movierating.ramraj.activities.search.dagger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.movierating.ramraj.activities.search.mvp.SearchModel;
import com.movierating.ramraj.activities.search.mvp.SearchPresenter;
import com.movierating.ramraj.activities.search.mvp.view.SearchView;
import com.movierating.ramraj.adapter.SearchMoviesAdapter;
import com.movierating.ramraj.app.network.CoreNetwork;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 4/19/17.
 */
@Module
public class SearchModule {
    @SearchScope
    @Provides
    public SearchModel homeModel(AppCompatActivity activity,CoreNetwork coreNetwork) {
        return new SearchModel(activity,coreNetwork);
    }

    @SearchScope
    @Provides
    public SearchView homeView(AppCompatActivity activity) {
        return new SearchView(activity);
    }

    @SearchScope
    @Provides
    public SearchPresenter homePresenter(SearchModel model, SearchView view) {
        return new SearchPresenter(model,view);
    }

}

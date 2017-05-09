package com.movierating.ramraj.activities.search.dagger;

import com.movierating.ramraj.activities.search.mvp.view.SearchView;
import com.movierating.ramraj.app.dagger.AppComponent;
import com.movierating.ramraj.app.network.CoreNetwork;

import dagger.Component;

/**
 * Created by ramraj on 5/2/17.
 */
@SearchScope
@Component(modules = {SearchItemAdapterModule.class,SearchActivityModule.class},dependencies = AppComponent.class)
public interface SearchViewComponent {
    void inject(SearchView view);
}

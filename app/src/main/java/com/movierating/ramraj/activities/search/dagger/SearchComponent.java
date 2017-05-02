package com.movierating.ramraj.activities.search.dagger;

import com.movierating.ramraj.activities.search.SearchActivity;
import com.movierating.ramraj.app.dagger.AppComponent;

import dagger.Component;

/**
 * Created by ramraj on 4/19/17.
 */
@SearchScope
@Component(modules = {SearchModule.class,SearchActivityModule.class},dependencies = AppComponent.class)
public interface SearchComponent {
    void inject(SearchActivity activity);
}

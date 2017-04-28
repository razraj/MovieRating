package com.movierating.ramraj.activities.browse.dagger;

import com.movierating.ramraj.activities.browse.BrowseFragment;
import com.movierating.ramraj.app.dagger.AppComponent;

import dagger.Component;

/**
 * Created by ramraj on 4/25/17.
 */
@BrowseScope
@Component(modules = {BrowseModule.class,BrowseActivityModule.class},dependencies = AppComponent.class)
public interface BrowseComponent {
    void inject(BrowseFragment fragment);
}

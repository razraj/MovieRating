package com.movierating.ramraj.activities.browse.dagger;

import com.movierating.ramraj.activities.browse.mvp.BrowseView;

import dagger.Component;

/**
 * Created by ramraj on 10-05-2017.
 */
@BrowseScope
@Component(modules = {BrowseAdapterModule.class,BrowseActivityModule.class})
public interface BrowseAdapterComponent {
    void inject(BrowseView view);
}

package com.movierating.ramraj.activities.browse.dagger;

import android.app.Activity;
import android.content.Context;

import com.movierating.ramraj.adapter.BrowseRecyclerAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 10-05-2017.
 */
@Module
public class BrowseAdapterModule {
    private final Context context;

    public BrowseAdapterModule(final Context context) {
        this.context = context;
    }

    @BrowseScope
    @Provides
    BrowseRecyclerAdapter browseRecyclerAdapter() {
        return new BrowseRecyclerAdapter(context);
    }
}

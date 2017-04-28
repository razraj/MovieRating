package com.movierating.ramraj.activities.browse.dagger;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 4/25/17.
 */
@Module
public class BrowseActivityModule {
    public final Activity activity;

    public BrowseActivityModule(Activity activity) {
        this.activity = activity;
    }

    @BrowseScope
    @Provides
    public Activity activity(){
        return activity;
    }
}

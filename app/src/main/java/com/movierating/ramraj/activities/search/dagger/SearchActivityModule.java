package com.movierating.ramraj.activities.search.dagger;

import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 5/2/17.
 */
@Module
public class SearchActivityModule {
    public AppCompatActivity activity;

    public SearchActivityModule(AppCompatActivity activity){
        this.activity=activity;
    }

    @SearchScope
    @Provides
    public AppCompatActivity activity(){
        return activity;
    }
}

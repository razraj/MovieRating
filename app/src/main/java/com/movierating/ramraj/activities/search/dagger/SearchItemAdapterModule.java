package com.movierating.ramraj.activities.search.dagger;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.movierating.ramraj.adapter.SearchMoviesAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 5/2/17.
 */
@Module
public class SearchItemAdapterModule {

    @SearchScope
    @Provides
    public SearchMoviesAdapter searchMoviesAdapter(AppCompatActivity context){
        return new SearchMoviesAdapter(context);
    }
}

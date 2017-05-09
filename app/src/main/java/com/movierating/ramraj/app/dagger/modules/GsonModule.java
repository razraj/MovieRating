package com.movierating.ramraj.app.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.movierating.ramraj.app.dagger.AppScope;
import com.movierating.ramraj.ext.CoreAdapterFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 12/4/17.
 */

@Module
public class GsonModule {

    @AppScope
    @Provides
    public Gson context() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(CoreAdapterFactory.create())
                .create();
    }
}

package com.movierating.ramraj.app.dagger.modules;

import android.app.Application;
import android.content.Context;


import com.movierating.ramraj.app.dagger.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 12/4/17.
 */
@Module
public class AppModule {
    private final Context context;

    public AppModule(Application application) {
        this.context = application.getApplicationContext();
    }

    @AppScope
    @Provides
    public Context getContext() {
        return context;
    }
}

package com.movierating.ramraj.app;

import android.app.Activity;
import android.app.Application;

import com.movierating.ramraj.BuildConfig;
import com.movierating.ramraj.app.dagger.AppComponent;
import com.movierating.ramraj.app.dagger.DaggerAppComponent;
import com.movierating.ramraj.app.dagger.modules.AppModule;
import com.movierating.ramraj.ext.Constants;

import timber.log.Timber;

/**
 * Created by ramraj on 4/19/17.
 */

public class CoreApplication extends Application {
    private AppComponent appComponent;


    public static CoreApplication get(Activity activity) {
        return (CoreApplication) activity.getApplication();
    }
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    super.log(priority, Constants.LOGTAG, message, t);
                }
            });
        }

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent component() {
        return appComponent;
    }

}

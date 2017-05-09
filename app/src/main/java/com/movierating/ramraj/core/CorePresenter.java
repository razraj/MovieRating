package com.movierating.ramraj.core;

import rx.Subscription;

/**
 * Created by ramraj on 12/4/17.
 */

public abstract class CorePresenter {

    public abstract void onCreate();

    public abstract void onDestroy();

    protected abstract Subscription loadSavedState();
}

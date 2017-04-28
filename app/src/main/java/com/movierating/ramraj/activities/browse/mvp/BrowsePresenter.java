package com.movierating.ramraj.activities.browse.mvp;

import android.util.Log;

import com.movierating.ramraj.core.CorePresenter;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by ramraj on 4/25/17.
 */

public class BrowsePresenter extends CorePresenter {

    /*isTrue for the fragment movies and false for tvSeries*/
    private boolean isMovies=false;
    private static final String TAG = BrowsePresenter.class.getSimpleName();
    private final BrowseModel model;
    private final BrowseView view;
    private CompositeSubscription subscription;

    public BrowsePresenter(BrowseModel model, BrowseView view) {
        this.model = model;
        this.view = view;
        subscription = new CompositeSubscription();
    }

    public void setMovies(boolean movies) {
        isMovies = movies;
    }

    @Override
    public void onCreate() {
        if (isMovies)
            subscription.add(browseMoviesCategories());
        else subscription.add(browseTvSeriesCategories());
        subscription.add(loadSavedState());
    }

    @Override
    public void onDestroy() {
        subscription.clear();
    }

    @Override
    protected Subscription loadSavedState() {
        if (isMovies)
            return model.browseMoviesCategoriesFromSavedState().subscribe();
        else return model.browseTvSeriesCategoriesFromSavedState().subscribe();
    }

    private Subscription browseMoviesCategories() {
        return model.browseMoviesCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(model::saveBrowseMoviesCategoriesInSaveState)
                .subscribe(view::setupBrowseGridData, Timber::d, () -> Log.d(TAG, "browseMoviesCategories: completed"));

    }

    private Subscription browseTvSeriesCategories() {
        return model.browseTvSeriesCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(model::saveBrowseTvSeriesCategoriesInSaveState)
                .subscribe(view::setupBrowseGridData, Timber::d, () -> Log.d(TAG, "browseMoviesCategories: completed"));
    }
}

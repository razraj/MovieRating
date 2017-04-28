package com.movierating.ramraj.activities.search.mvp;

import com.movierating.ramraj.activities.search.mvp.view.SearchView;
import com.movierating.ramraj.core.CorePresenter;

import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by ramraj on 4/19/17.
 */

public class SearchPresenter extends CorePresenter {

    private final SearchModel model;
    private final SearchView view;
    private final CompositeSubscription subscription = new CompositeSubscription();

    public SearchPresenter(SearchModel model, SearchView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onCreate() {
        subscription.add(searchMovie());
        subscription.add(loadSavedState());
    }

    @Override
    public void onDestroy() {
        subscription.clear();
    }

    @Override
    protected Subscription loadSavedState() {
        return model.getSearchResultsFromSavedState().subscribe(moviesLists -> view.showToast("jkabsdjk"));
    }

//    private Subscription lookupMoviesButton() {
//        return view.searchMovie()
//                .doOnNext(__ -> view.showLoading(true))
//                .doOnError(Timber::d)
//                .map(__ -> view.getSearchString())
//                .observeOn(Schedulers.io())
//                .switchMap(searchString -> model.getSearchResultsFromNetwork(searchString, 1, false))
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(model::saveSearchResultsInSavedState)
//                .doOnError(Timber::d)
//                .doOnEach(__ -> view.showLoading(false))
//                .retry()
//                .subscribe(model::startMoviesListActivity);
//
//    }

    private Subscription searchMovie(){
        return view.searchMovie()
                .filter(charSequence -> charSequence.length()>2)
                .debounce(100, TimeUnit.MILLISECONDS)
                .switchMap(charSequence -> model.getSearchResultsFromNetwork(charSequence.toString(),1,false))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(model::saveSearchResultsInSavedState)
                .doOnError(Timber::d)
                .retry()
                .subscribe(view::setAutocompleteListData, Timber::d);
    }
}

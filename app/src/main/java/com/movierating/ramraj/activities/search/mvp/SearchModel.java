package com.movierating.ramraj.activities.search.mvp;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.movierating.ramraj.app.network.CoreNetwork;
import com.movierating.ramraj.app.network.model.SearchDO;
import com.movierating.ramraj.ext.Constants;
import com.twistedequations.rxstate.RxSaveState;

import rx.Observable;

/**
 * Created by ramraj on 4/19/17.
 */

public class SearchModel {
    public static final String TAG = SearchModel.class.getSimpleName();
    public static final String HOME_SEARCH_STATE_KEY = "HOME_SEARCH_STATE_KEY";
    public static final String HOME_LIST_STATE_KEY = "HOME_LIST_STATE_KEY";
    private final AppCompatActivity activity;
    private final CoreNetwork coreNetwork;

    public SearchModel(AppCompatActivity activity, CoreNetwork coreNetwork) {
        this.activity = activity;
        this.coreNetwork = coreNetwork;
    }

    /*show all movies*/
//    public Observable<MoviesDO> getMovieListFromNetwork(String sortBy) {
//        return coreNetwork.getMovieList(sortBy, Constants.KEY);
//    }
//
//    public Observable<MoviesDO> getMovieListFromSavedState() {
//        return RxSaveState.getSavedState(activity)
//                .map(bundle -> bundle.getParcelable(HOME_LIST_STATE_KEY));
//    }
//
//    public void saveMovieListInSavedState(MoviesDO moviesLists) {
//        RxSaveState.updateSaveState(activity, bundle -> {
//            bundle.putParcelable(HOME_LIST_STATE_KEY, moviesLists);
//        });
//    }

    /*autocomplete data*/
    public Observable<SearchDO> getSearchResultsFromNetwork(String query,int page,boolean includeAdult){
        return coreNetwork.getMoviesSearchResult(Constants.KEY,Constants.LANGUAGE,query,page,includeAdult);
    }

    public Observable<SearchDO> getSearchResultsFromSavedState(){
        return RxSaveState.getSavedState(activity)
                .map(bundle -> bundle.getParcelable(HOME_SEARCH_STATE_KEY));
    }

    public void saveSearchResultsInSavedState(SearchDO searchDO){
        RxSaveState.updateSaveState(activity,bundle -> bundle.putParcelable(HOME_SEARCH_STATE_KEY,searchDO));
    }

    public void startMoviesListActivity(SearchDO repoList) {
//        ReposActivity.start(activity, repoList);
        Log.d(TAG, "startMoviesListActivity: " + repoList);
    }

}

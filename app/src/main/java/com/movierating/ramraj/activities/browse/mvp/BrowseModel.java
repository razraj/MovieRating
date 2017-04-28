package com.movierating.ramraj.activities.browse.mvp;

import android.app.Activity;
import android.util.Log;

import com.movierating.ramraj.app.network.CoreNetwork;
import com.movierating.ramraj.app.network.model.BrowseDO;
import com.movierating.ramraj.ext.Constants;
import com.twistedequations.rxstate.RxSaveState;

import rx.Observable;

/**
 * Created by ramraj on 4/25/17.
 */

public class BrowseModel {

    public static final String TAG = BrowseModel.class.getSimpleName();
    public static final String BROWSE_MOVIES_STATE_KEY = "BROWSE_MOVIES_STATE_KEY";
    public static final String BROWSE_TVSERIES_STATE_KEY = "BROWSE_TVSERIES_STATE_KEY";
    private final Activity activity;
    private final CoreNetwork network;

    public BrowseModel(Activity activity, CoreNetwork network) {
        this.activity = activity;
        this.network = network;
    }

    /*Movies categories*/
    public Observable<BrowseDO> browseMoviesCategories() {
        return network.getBrowseMoviesCategories(Constants.KEY, Constants.LANGUAGE);
    }

    public Observable<BrowseDO> browseMoviesCategoriesFromSavedState() {
        return RxSaveState.getSavedState(activity)
                .map(bundle -> bundle.getParcelable(BROWSE_MOVIES_STATE_KEY));
    }

    public void saveBrowseMoviesCategoriesInSaveState(BrowseDO browseDO) {
        RxSaveState.updateSaveState(activity, bundle -> bundle.putParcelable(BROWSE_MOVIES_STATE_KEY, browseDO));
    }

    /*tvSeries categories*/
    public Observable<BrowseDO> browseTvSeriesCategories() {
        return network.getBrowseTvSeriesCategories(Constants.KEY, Constants.LANGUAGE);
    }

    public Observable<BrowseDO> browseTvSeriesCategoriesFromSavedState() {
        return RxSaveState.getSavedState(activity)
                .map(bundle -> bundle.getParcelable(BROWSE_TVSERIES_STATE_KEY));
    }

    public void saveBrowseTvSeriesCategoriesInSaveState(BrowseDO browseDO) {
        RxSaveState.updateSaveState(activity, bundle -> bundle.putParcelable(BROWSE_TVSERIES_STATE_KEY, browseDO));
    }

    public void startNextActivity() {
        Log.d(TAG, "startNextActivity: ");
    }
}


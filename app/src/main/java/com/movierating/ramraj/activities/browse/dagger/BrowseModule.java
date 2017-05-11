package com.movierating.ramraj.activities.browse.dagger;

import android.app.Activity;

import com.movierating.ramraj.activities.browse.mvp.BrowseModel;
import com.movierating.ramraj.activities.browse.mvp.BrowsePresenter;
import com.movierating.ramraj.activities.browse.mvp.BrowseView;
import com.movierating.ramraj.adapter.BrowseRecyclerAdapter;
import com.movierating.ramraj.app.network.CoreNetwork;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ramraj on 4/25/17.
 */
@Module
public class BrowseModule {

    @BrowseScope
    @Provides
    public BrowseModel browseModel(Activity activity, CoreNetwork network){
        return new BrowseModel(activity,network);
    }

    @BrowseScope
    @Provides
    public BrowseView browseView(Activity activity){
        return new BrowseView(activity);
    }

    @BrowseScope
    @Provides
    public BrowsePresenter browsePresenter(BrowseView view,BrowseModel model){
        return new BrowsePresenter(model,view);
    }
}

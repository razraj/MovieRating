package com.movierating.ramraj.activities.browse.mvp;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.FrameLayout;

import com.movierating.ramraj.R;
import com.movierating.ramraj.activities.browse.dagger.BrowseActivityModule;
import com.movierating.ramraj.activities.browse.dagger.BrowseAdapterModule;
import com.movierating.ramraj.activities.browse.dagger.DaggerBrowseAdapterComponent;
import com.movierating.ramraj.adapter.BrowseRecyclerAdapter;
import com.movierating.ramraj.adapter.GridSpacingItemDecoration;
import com.movierating.ramraj.app.network.model.BrowseDO;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.movierating.ramraj.ext.Utils.dpToPx;

/**
 * Created by ramraj on 4/25/17.
 */

public class BrowseView extends FrameLayout {

    @Inject
    BrowseRecyclerAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public BrowseView(Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.fragment_browse, this);
        ButterKnife.bind(this);

        DaggerBrowseAdapterComponent.builder()
                .browseAdapterModule(new BrowseAdapterModule(getContext()))
                .build().inject(this);

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void filterResults(String value) {
        adapter.filter(value);
    }

    public void setupBrowseGridData(BrowseDO browseDO) {
        adapter.updateData(browseDO.genres());
        recyclerView.setAdapter(adapter);
    }

}

package com.movierating.ramraj.activities.browse.mvp;

import android.app.Activity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.FrameLayout;

import com.movierating.ramraj.R;
import com.movierating.ramraj.adapter.BrowseRecyclerAdapter;
import com.movierating.ramraj.adapter.GridSpacingItemDecoration;
import com.movierating.ramraj.app.network.model.BrowseDO;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.movierating.ramraj.ext.Utils.dpToPx;

/**
 * Created by ramraj on 4/25/17.
 */

public class BrowseView extends FrameLayout {

    private BrowseRecyclerAdapter adapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public BrowseView(Activity activity) {
        super(activity);
        inflate(getContext(), R.layout.fragment_browse, this);
        ButterKnife.bind(this);

        final StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
    }

    public void filterResults(String value){
        adapter.filter(value);
    }

    public void setupBrowseGridData(BrowseDO browseDO) {
        if (adapter == null) adapter = new BrowseRecyclerAdapter(getContext(), browseDO.genres());
        else adapter.updateData(browseDO.genres());
        recyclerView.setAdapter(adapter);
    }

}

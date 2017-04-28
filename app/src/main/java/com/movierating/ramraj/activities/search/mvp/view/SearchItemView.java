package com.movierating.ramraj.activities.search.mvp.view;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.movierating.ramraj.R;
import com.movierating.ramraj.app.network.model.Search;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramraj on 4/24/17.
 */

public class SearchItemView extends FrameLayout {

    @BindView(R.id.movie_image)
    ImageView movieImage;

    @BindView(R.id.movie_name)
    TextView movieTitle;

    public SearchItemView(Context context){
        super(context);
        inflate(getContext(),R.layout.search_list_item_view,this);
        ButterKnife.bind(this);
    }

    public void bind(Search searchData){
        movieTitle.setText(searchData.title());
    }
}

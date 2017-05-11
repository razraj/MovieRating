package com.movierating.ramraj.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.movierating.ramraj.R;
import com.movierating.ramraj.app.network.model.Genres;
import com.movierating.ramraj.ext.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramraj on 4/25/17.
 */

public class BrowseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int PHOTO_ANIMATION_DELAY = 600;
    private static final Interpolator INTERPOLATOR = new DecelerateInterpolator();

    private final Context context;
    private List<Genres> genresList, originalGenreList;
    private final int cellSize;


    private boolean lockedAnimations = false;
    private int lastAnimatedItem = -1;

    public BrowseRecyclerAdapter(Context context) {
        this.context = context;
        this.genresList = new ArrayList<>();
        this.originalGenreList = new ArrayList<>();
        this.cellSize = Utils.getScreenWidth(context) / 2;
    }

    public void updateData(List<Genres> genresList) {

        if (this.genresList != null && !this.genresList.isEmpty()) {
            this.genresList.clear();
            this.originalGenreList.clear();
            this.genresList.addAll(genresList);
            this.originalGenreList.addAll(genresList);
        } else {
            this.genresList.addAll(genresList);
            this.originalGenreList.addAll(genresList);
        }
        notifyDataSetChanged();
    }

    public void filter(String text) {
        List<Genres> temp = new ArrayList();
        //or use .contains(text)
        for (Genres d : originalGenreList)
            if (d.name().toLowerCase().contains(text.toLowerCase())) {
                temp.add(d);
            }
        //update recyclerview
        updateList(temp);
    }

    public void updateList(List<Genres> list) {
        genresList = list;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.browse_grid_item_view, parent, false);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.height = cellSize;
        layoutParams.width = cellSize;
        layoutParams.setFullSpan(false);
        view.setLayoutParams(layoutParams);
        return new GenresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bind((GenresViewHolder) holder, position);
    }

    private void bind(final GenresViewHolder holder, final int position) {
        holder.categoryName.setText(genresList.get(position).name());
    }

    @Override
    public long getItemId(int position) {
        return genresList.get(position).id();
    }

    @Override
    public int getItemCount() {
        return genresList.size() > 0 ? genresList.size() : 0;
    }


    static class GenresViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.category_name)
        TextView categoryName;

        public GenresViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

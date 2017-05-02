package com.movierating.ramraj.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.movierating.ramraj.R;
import com.movierating.ramraj.app.network.model.Search;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramraj on 4/24/17.
 */

public class SearchMoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Inject
    Picasso picasso;

    private Context context;
    private List<Search> searchList = new ArrayList<>();

    public SearchMoviesAdapter(Context context) {
        this.context = context;
    }

    public void updateData(List<Search> searchList) {
        this.searchList.clear();
        if (searchList != null && !searchList.isEmpty()) {
            this.searchList.addAll(searchList);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.search_list_item_view, parent, false);
        return new SearchItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bind((SearchItemViewHolder) holder, position);
    }

    private void bind(final SearchItemViewHolder holder, final int position) {
        holder.movieTitle.setText(searchList.get(position).title());
        picasso.with(context).load("https://image.tmdb.org/t/p/w500/" + searchList.get(position).posterPath()).into(holder.movieImage);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return searchList.size() > 0 ? searchList.size() : 0;
    }

    static class SearchItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.movie_image)
        ImageView movieImage;

        @BindView(R.id.movie_name)
        TextView movieTitle;

        public SearchItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

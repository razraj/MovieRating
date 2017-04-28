package com.movierating.ramraj.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.movierating.ramraj.activities.search.mvp.view.SearchItemView;
import com.movierating.ramraj.app.network.model.Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramraj on 4/24/17.
 */

public class SearchMoviesAdapter extends BaseAdapter {

    private List<Search> searchList = new ArrayList<>();

    public SearchMoviesAdapter(Context context, List<Search> searchList) {
//        super(context, 0, searchList);
        this.searchList = searchList;
    }

    public void updateData(List<Search> searchList) {
        this.searchList.clear();
        if (searchList != null && !searchList.isEmpty()) {
            this.searchList.addAll(searchList);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return searchList.size() > 0 ? searchList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return searchList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SearchItemView listItem;

        if (convertView == null) {
            listItem = new SearchItemView(parent.getContext());
        } else {
            listItem = SearchItemView.class.cast(convertView);
        }
        listItem.bind(searchList.get(position));


        return listItem;

    }

}

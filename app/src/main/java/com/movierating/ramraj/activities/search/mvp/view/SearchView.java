package com.movierating.ramraj.activities.search.mvp.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.movierating.ramraj.R;
import com.movierating.ramraj.adapter.SearchMoviesAdapter;
import com.movierating.ramraj.app.network.model.SearchDO;
import com.movierating.ramraj.core.BaseDrawerActivityView;
import com.movierating.ramraj.core.CoreActivityView;

import butterknife.BindView;
import rx.Observable;

/**
 * Created by ramraj on 4/19/17.
 */
@SuppressLint("ViewConstructor")
public class SearchView extends CoreActivityView {

    private static final String TAG = SearchView.class.getSimpleName();
    private ProgressDialog progressDialog;
    private SearchMoviesAdapter searchMoviesAdapter;

    @BindView(R.id.autoCompleteTextView)
    AutoCompleteTextView autocompleteView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    public SearchView(AppCompatActivity activity) {
        super(activity);

        setContentView(R.layout.app_bar_main, false);

        progressDialog = new ProgressDialog(getContext());

        progressDialog.setTitle("loading");

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

    }

    public void showToast(String msg) {
        Toast.makeText(getContext(), "as,jdbnas", Toast.LENGTH_SHORT).show();
    }

    public Observable<CharSequence> searchMovie() {
        return RxTextView.textChanges(autocompleteView);
    }

    public void setAutocompleteListData(SearchDO searchDO) {
        if (searchMoviesAdapter == null)
            searchMoviesAdapter = new SearchMoviesAdapter(getContext(), searchDO.movies());
        else searchMoviesAdapter.updateData(searchDO.movies());
        recyclerView.setAdapter(searchMoviesAdapter);
    }

    public void showLoading(Boolean loading) {
        if (loading) progressDialog.show();
        else progressDialog.dismiss();
    }
}

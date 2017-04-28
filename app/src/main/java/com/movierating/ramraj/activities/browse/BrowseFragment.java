package com.movierating.ramraj.activities.browse;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movierating.ramraj.activities.browse.dagger.BrowseActivityModule;
import com.movierating.ramraj.activities.browse.dagger.DaggerBrowseComponent;
import com.movierating.ramraj.activities.browse.mvp.BrowsePresenter;
import com.movierating.ramraj.activities.browse.mvp.BrowseView;
import com.movierating.ramraj.app.CoreApplication;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrowseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowseFragment extends Fragment {

    @Inject
    BrowseView view;

    @Inject
    BrowsePresenter presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public BrowseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BrowseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrowseFragment newInstance(String param1) {
        BrowseFragment fragment = new BrowseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public void setSearchString(String value){
        if (mParam1.equals("movies"))
            view.filterResults(value);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DaggerBrowseComponent.builder()
                .appComponent(CoreApplication.get(getActivity()).component())
                .browseActivityModule(new BrowseActivityModule(getActivity()))
                .build().inject(this);

        if (mParam1.equals("movies"))
            presenter.setMovies(true);
        else presenter.setMovies(false);
        presenter.onCreate();
        return view;
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}

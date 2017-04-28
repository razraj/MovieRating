package com.movierating.ramraj.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.movierating.ramraj.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ramraj on 4/21/17.
 */
@SuppressLint("ViewConstructor")
public class CoreActivityView extends FrameLayout {

    @Nullable
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    protected AppCompatActivity activity;

    public CoreActivityView(@NonNull AppCompatActivity activity) {
        super(activity);
        this.activity = activity;

    }

    /**
     * @param ressID resource ID
     * @param value  true if activity contains toolbar
     */
    protected void setContentView(@NonNull int ressID,@NonNull boolean value) {
        inflate(getContext(), ressID, this);
        ButterKnife.bind(this);
        if (value)
            setupToolbar();
    }

    private void setupToolbar() {
        activity.setSupportActionBar(toolbar);
    }
}

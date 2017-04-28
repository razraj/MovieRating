package com.movierating.ramraj.core;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.movierating.ramraj.R;

import butterknife.BindView;

/**
 * Created by ramraj on 4/21/17.
 */

public class BaseDrawerActivityView extends CoreActivityView implements NavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    public BaseDrawerActivityView(@NonNull AppCompatActivity activity) {
        super(activity);
    }

    public DrawerLayout getDrawer() {
        return drawer;
    }


    @Override
    protected void setContentView(@NonNull int ressID, @NonNull boolean value) {
        super.setContentView(ressID, value);
        setDrawer();
    }

    private void setDrawer(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                activity, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}

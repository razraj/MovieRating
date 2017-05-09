package com.movierating.ramraj.app.dagger;

import android.content.Context;

import com.movierating.ramraj.app.dagger.modules.AppModule;
import com.movierating.ramraj.app.dagger.modules.GsonModule;
import com.movierating.ramraj.app.dagger.modules.NetworkModule;
import com.movierating.ramraj.app.network.CoreNetwork;
import com.squareup.picasso.Picasso;

import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by ramraj on 12/4/17.
 */
@AppScope
@Component(modules = {AppModule.class,NetworkModule.class, GsonModule.class})
public interface AppComponent {

    Context context();

    OkHttpClient okhttpClient();

    CoreNetwork githubNetwork();

    Picasso picasso();
}

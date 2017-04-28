package com.movierating.ramraj.app.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by ramraj on 4/24/17.
 */
@AutoValue
public abstract class Genres implements Parcelable{

    public static TypeAdapter<Genres> typeAdapter(Gson gson) {
        return new AutoValue_Genres.GsonTypeAdapter(gson);
    }

    public abstract int id();
    public abstract String name();
}

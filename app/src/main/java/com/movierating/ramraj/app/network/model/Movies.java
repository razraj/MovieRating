package com.movierating.ramraj.app.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ramraj on 4/19/17.
 */
@AutoValue
public abstract class Movies implements Parcelable {

    public static TypeAdapter<Movies> typeAdapter(Gson gson) {
        return new AutoValue_Movies.GsonTypeAdapter(gson);
    }

    @SerializedName("original_title")
    public abstract String originalTitle();

    public abstract String overview();

    @SerializedName("original_language")
    public abstract String originalLanguage();
}

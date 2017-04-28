package com.movierating.ramraj.app.network.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ramraj on 4/22/17.
 */
@AutoValue
public abstract class Search implements Parcelable {

    public static TypeAdapter<Search> typedArray(Gson gson) {
        return new AutoValue_Search.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("poster_path")
    public abstract String posterPath();

    @SerializedName("title")
    public abstract String title();

    @Nullable
    @SerializedName("backdrop_path")
    public abstract String backdropPath();

}

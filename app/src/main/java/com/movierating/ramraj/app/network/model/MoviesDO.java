package com.movierating.ramraj.app.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ramraj on 4/20/17.
 */
@AutoValue
public abstract class MoviesDO implements Parcelable{
    public static TypeAdapter<MoviesDO> typeAdapter(Gson gson){
        return new AutoValue_MoviesDO.GsonTypeAdapter(gson);
    }

    @SerializedName("page")
    public abstract String page();

    @SerializedName("results")
    public abstract List<Movies> movies();

}

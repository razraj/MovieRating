package com.movierating.ramraj.app.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ramraj on 4/22/17.
 */
@AutoValue
public abstract class SearchDO implements Parcelable{

    public static TypeAdapter<SearchDO> typeAdapter(Gson gson){
        return new AutoValue_SearchDO.GsonTypeAdapter(gson);
    }

    @SerializedName("page")
    public abstract String page();

    @SerializedName("results")
    public abstract List<Search> movies();

}

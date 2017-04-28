package com.movierating.ramraj.app.network.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.ArrayList;

/**
 * Created by ramraj on 4/24/17.
 */

@AutoValue
public abstract class BrowseDO implements Parcelable{
    public static TypeAdapter<BrowseDO> typeAdapter(Gson gson){
        return new AutoValue_BrowseDO.GsonTypeAdapter(gson);
    }

    public abstract ArrayList<Genres> genres();

}

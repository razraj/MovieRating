package com.movierating.ramraj.app.network;

import com.movierating.ramraj.app.network.model.BrowseDO;
import com.movierating.ramraj.app.network.model.MoviesDO;
import com.movierating.ramraj.app.network.model.SearchDO;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ramraj on 12/4/17.
 */

public interface CoreNetwork {

    //    http://api.themoviedb.org/3/discover/movie?
    // ort_by=popularity&
    // api_key=b46ae5f56e199853195829caf6ab6ac8
    @GET("discover/movie")
    Observable<MoviesDO> getMovieList(@Query("ort_by") String ort_by,
                                      @Query("api_key") String apiKey);

    //    https://api.themoviedb.org/3/search/movie?
    // api_key=b46ae5f56e199853195829caf6ab6ac8&l
    // anguage=en-US&
    // query=kong&
    // page=1&
    // include_adult=false
    @GET("search/movie")
    Observable<SearchDO> getMoviesSearchResult(@Query("api_key") String key,
                                               @Query("language") String language,
                                               @Query("query") String query,
                                               @Query("page") int page,
                                               @Query("include_adult") boolean include_adult);

    //    https://api.themoviedb.org/3/genre/movie/list?
    // api_key=b46ae5f56e199853195829caf6ab6ac8
    // &language=en-US
    @GET("genre/movie/list")
    Observable<BrowseDO> getBrowseMoviesCategories(@Query("api_key") String key,
                                                   @Query("language") String language);

    //    https://api.themoviedb.org/3/genre/tv/list?
    // api_key=b46ae5f56e199853195829caf6ab6ac8&
    // language=en-US
    @GET("genre/tv/list")
    Observable<BrowseDO> getBrowseTvSeriesCategories(@Query("api_key") String key,
                                                     @Query("language") String language);
}

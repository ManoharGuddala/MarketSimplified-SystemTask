package com.tilicho.marketsimplifiedsystemtask.data.remote;

import com.tilicho.marketsimplifiedsystemtask.data.remote.models.Repositories;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/repositories")
    public Observable<Repositories> performGetPublicReposCall(@Query("limit")int limit, @Query("offset") int offSet);

}

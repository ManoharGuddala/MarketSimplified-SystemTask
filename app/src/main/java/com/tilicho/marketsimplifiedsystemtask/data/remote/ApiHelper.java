package com.tilicho.marketsimplifiedsystemtask.data.remote;

import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.Repositories;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Query;

public interface ApiHelper {

    Observable<List<PublicRepository>> doPublicRepoGetCall(@Query("since") long lastRepoId);

}

package com.tilicho.marketsimplifiedsystemtask.data.remote;

import com.tilicho.marketsimplifiedsystemtask.data.remote.models.Repositories;

import io.reactivex.Observable;

public interface ApiHelper {

    Observable<Repositories> doCharactersListCall();

}

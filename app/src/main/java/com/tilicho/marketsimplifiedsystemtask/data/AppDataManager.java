package com.tilicho.marketsimplifiedsystemtask.data;

import android.content.Context;

import com.google.gson.Gson;
import com.tilicho.marketsimplifiedsystemtask.data.local.db.DatabaseHelper;
import com.tilicho.marketsimplifiedsystemtask.data.local.prefs.PreferencesHelper;
import com.tilicho.marketsimplifiedsystemtask.data.remote.ApiHelper;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.Repositories;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDataManager implements DataManager{

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DatabaseHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DatabaseHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson){
        this.mContext = context;
        this.mApiHelper = apiHelper;
        this.mDbHelper = dbHelper;
        this.mPreferencesHelper = preferencesHelper;
        this.mGson = gson;
    }

    @Override
    public Observable<List<PublicRepository>> doPublicRepoGetCall(long lastRepoId) {
        return mApiHelper.doPublicRepoGetCall(lastRepoId);
    }
}

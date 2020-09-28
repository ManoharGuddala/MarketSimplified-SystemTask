package com.tilicho.marketsimplifiedsystemtask.ui.ui.home;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.Repositories;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class RepositoriesDataSourceClass extends PageKeyedDataSource<Long, PublicRepository> {

    private DataManager mDataManager;
    private Gson mGson;
    private MutableLiveData<String> progressLiveStatus;
    private CompositeDisposable mCompositeDisposable;

    RepositoriesDataSourceClass(DataManager dataManager, CompositeDisposable mCompositeDisposable){
        this.mDataManager = dataManager;
        this.mCompositeDisposable = mCompositeDisposable;
        this.progressLiveStatus = new MutableLiveData<>();
        mGson = new Gson();
    }

    public MutableLiveData<String> getProgressLiveStatus() {
        return progressLiveStatus;
    }

    @SuppressLint("CheckResult")
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, PublicRepository> callback) {
        mDataManager.doPublicRepoGetCall(0)
                .doOnSubscribe(disposable -> {
                    mCompositeDisposable.add(disposable);
                    progressLiveStatus.postValue("Loading...");
                })
                .subscribe((List<PublicRepository> result) -> {
                    progressLiveStatus.postValue("Loaded");
                    List<PublicRepository> list = result;
                    callback.onResult(list, null, list.get(list.size()-1).id);
                }, throwable -> {
                    progressLiveStatus.postValue("Loaded");
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, PublicRepository> callback) {

    }

    @SuppressLint("CheckResult")
    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, PublicRepository> callback) {
        mDataManager.doPublicRepoGetCall(params.key)
                .doOnSubscribe(disposable ->
                {
                    mCompositeDisposable.add(disposable);
                    progressLiveStatus.postValue("Loading...");
                })
                .subscribe((List<PublicRepository> result) -> {
                    progressLiveStatus.postValue("Loaded");
                    List<PublicRepository> list = result;
                    callback.onResult(list, list.get(list.size()-1).id);
                }, throwable -> {
                    progressLiveStatus.postValue("Loaded");
                });
    }
}

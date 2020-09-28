package com.tilicho.marketsimplifiedsystemtask.ui.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.Repositories;

import io.reactivex.disposables.CompositeDisposable;

public class RepoDataSourceFactory extends DataSource.Factory<Long, PublicRepository> {

    private MutableLiveData<RepositoriesDataSourceClass> liveData;
    private DataManager dataManager;
    private CompositeDisposable compositeDisposable;

    public RepoDataSourceFactory(DataManager dataManager, CompositeDisposable compositeDisposable) {
        this.dataManager = dataManager;
        this.compositeDisposable = compositeDisposable;
        liveData = new MutableLiveData<>();
    }

    public MutableLiveData<RepositoriesDataSourceClass> getMutableLiveData() {
        return liveData;
    }

    @Override
    public DataSource<Long, PublicRepository> create() {
        RepositoriesDataSourceClass dataSourceClass = new RepositoriesDataSourceClass(dataManager, compositeDisposable);
        liveData.postValue(dataSourceClass);
        return dataSourceClass;
    }
}

package com.tilicho.marketsimplifiedsystemtask.ui.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.Repositories;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.base.BaseViewModel;
import com.tilicho.marketsimplifiedsystemtask.utils.ScheduleProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class RepositoriesViewModel extends BaseViewModel {

    private LiveData<PagedList<PublicRepository>> mReposList;
    private RepoDataSourceFactory mRepoDataSourceFactory;

    private LiveData<String> progressLoadStatus = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public RepositoriesViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        mRepoDataSourceFactory = new RepoDataSourceFactory(getDataManager(), getCompositeDisposable());
        initializePaging();
    }

    private void initializePaging(){
        PagedList.Config pagedListConfig = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build();
        mReposList = new LivePagedListBuilder<>(mRepoDataSourceFactory, pagedListConfig).build();
        progressLoadStatus = Transformations.switchMap(mRepoDataSourceFactory.getMutableLiveData(), RepositoriesDataSourceClass::getProgressLiveStatus);
    }

    public LiveData<String> getProgressLoadStatus() {
        return progressLoadStatus;
    }

    public LiveData<PagedList<PublicRepository>> getListLiveData() {
        return mReposList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

}
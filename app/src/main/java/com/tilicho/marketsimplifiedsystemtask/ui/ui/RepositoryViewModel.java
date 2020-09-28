package com.tilicho.marketsimplifiedsystemtask.ui.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.data.remote.models.PublicRepository;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.base.BaseViewModel;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.home.RepoDataSourceFactory;
import com.tilicho.marketsimplifiedsystemtask.utils.ScheduleProvider;

public class RepositoryViewModel extends BaseViewModel {

    MutableLiveData<PublicRepository> selectedRepo = new MutableLiveData<>();

    public RepositoryViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void initialise(PublicRepository repo){
        selectedRepo.setValue(repo);
    }

}

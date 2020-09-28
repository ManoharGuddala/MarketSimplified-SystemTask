package com.tilicho.marketsimplifiedsystemtask.di.modules;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.tilicho.marketsimplifiedsystemtask.ViewModelProviderFactory;
import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.RepositoryViewModel;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.base.BaseActivity;
import com.tilicho.marketsimplifiedsystemtask.utils.ScheduleProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private BaseActivity<?, ?> activity;

    public ActivityModule(BaseActivity<?, ?> activity) {
        this.activity = activity;
    }

    @Provides
    RepositoryViewModel provideFeedViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        Supplier<RepositoryViewModel> supplier = () -> new RepositoryViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<RepositoryViewModel> factory = new ViewModelProviderFactory<>(RepositoryViewModel.class, supplier);
        return new ViewModelProvider(activity, factory).get(RepositoryViewModel.class);
    }

}

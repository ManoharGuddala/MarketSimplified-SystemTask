package com.tilicho.marketsimplifiedsystemtask.di.modules;

import androidx.core.util.Supplier;
import androidx.lifecycle.ViewModelProvider;

import com.tilicho.marketsimplifiedsystemtask.ViewModelProviderFactory;
import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.base.BaseFragment;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.dashboard.RepoDetailsViewModel;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.home.RepositoriesViewModel;
import com.tilicho.marketsimplifiedsystemtask.utils.ScheduleProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private BaseFragment<?, ?> fragment;

    public FragmentModule(BaseFragment<?, ?> fragment) {
        this.fragment = fragment;
    }

    @Provides
    RepositoriesViewModel provideRepositoriesViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        Supplier<RepositoriesViewModel> supplier = () -> new RepositoriesViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<RepositoriesViewModel> factory = new ViewModelProviderFactory<>(RepositoriesViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(RepositoriesViewModel.class);
    }

    @Provides
    RepoDetailsViewModel provideRepoDetailsViewModel(DataManager dataManager, ScheduleProvider schedulerProvider) {
        Supplier<RepoDetailsViewModel> supplier = () -> new RepoDetailsViewModel(dataManager, schedulerProvider);
        ViewModelProviderFactory<RepoDetailsViewModel> factory = new ViewModelProviderFactory<>(RepoDetailsViewModel.class, supplier);
        return new ViewModelProvider(fragment, factory).get(RepoDetailsViewModel.class);
    }

}

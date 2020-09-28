package com.tilicho.marketsimplifiedsystemtask.di.components;

import com.tilicho.marketsimplifiedsystemtask.di.modules.FragmentModule;
import com.tilicho.marketsimplifiedsystemtask.di.scopes.FragmentScope;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.dashboard.DetailsFragment;
import com.tilicho.marketsimplifiedsystemtask.ui.ui.home.RepositoriesFragment;

import dagger.Component;

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(RepositoriesFragment fragment);

    void inject(DetailsFragment fragment);

}


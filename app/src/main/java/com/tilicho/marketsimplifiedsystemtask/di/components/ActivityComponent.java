package com.tilicho.marketsimplifiedsystemtask.di.components;

import com.tilicho.marketsimplifiedsystemtask.di.modules.ActivityModule;
import com.tilicho.marketsimplifiedsystemtask.di.scopes.ActivityScope;
import com.tilicho.marketsimplifiedsystemtask.ui.RepositoriesActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(RepositoriesActivity activity);
}

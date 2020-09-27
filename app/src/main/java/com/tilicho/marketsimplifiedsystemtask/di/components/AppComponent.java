package com.tilicho.marketsimplifiedsystemtask.di.components;

import android.app.Application;
import android.os.Build;

import com.tilicho.marketsimplifiedsystemtask.MSApp;
import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.di.modules.AppModule;
import com.tilicho.marketsimplifiedsystemtask.utils.ScheduleProvider;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class
})
public interface AppComponent {

    void inject(MSApp app);

    DataManager getDataManager();

    ScheduleProvider getScheduleProvider();

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }


}

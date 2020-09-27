package com.tilicho.marketsimplifiedsystemtask;

import android.app.Application;

import com.tilicho.marketsimplifiedsystemtask.di.components.AppComponent;
import com.tilicho.marketsimplifiedsystemtask.di.components.DaggerAppComponent;

public class MSApp extends Application {

    private static MSApp msApp;
    private static AppConfig appConfig;

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .application(this)
                .build();

        appComponent.inject(this);

    }
}

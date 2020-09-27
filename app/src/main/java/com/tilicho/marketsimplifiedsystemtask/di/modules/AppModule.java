package com.tilicho.marketsimplifiedsystemtask.di.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tilicho.marketsimplifiedsystemtask.AppConfig;
import com.tilicho.marketsimplifiedsystemtask.data.AppDataManager;
import com.tilicho.marketsimplifiedsystemtask.data.DataManager;
import com.tilicho.marketsimplifiedsystemtask.data.local.db.AppDatabase;
import com.tilicho.marketsimplifiedsystemtask.data.local.db.AppDatabaseHelper;
import com.tilicho.marketsimplifiedsystemtask.data.local.db.DatabaseHelper;
import com.tilicho.marketsimplifiedsystemtask.data.local.prefs.AppPreferencesHelper;
import com.tilicho.marketsimplifiedsystemtask.data.local.prefs.PreferencesHelper;
import com.tilicho.marketsimplifiedsystemtask.data.remote.ApiHelper;
import com.tilicho.marketsimplifiedsystemtask.data.remote.AppApiHelper;
import com.tilicho.marketsimplifiedsystemtask.di.scopes.DatabaseInfo;
import com.tilicho.marketsimplifiedsystemtask.di.scopes.PreferenceInfo;
import com.tilicho.marketsimplifiedsystemtask.utils.AppScheduleProvider;
import com.tilicho.marketsimplifiedsystemtask.utils.ScheduleProvider;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    Gson provideGson(){
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    ScheduleProvider provideScheduleProvider(){
        return new AppScheduleProvider();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    AppConfig provideAppConfig(AppConfig appConfig){
        return appConfig;
    }

    @Provides
    @Singleton
    DatabaseHelper provideDbHelper(AppDatabaseHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConfig.PREF_NAME;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConfig.DB_NAME;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

}

package com.tilicho.marketsimplifiedsystemtask.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.tilicho.marketsimplifiedsystemtask.di.scopes.PreferenceInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

}

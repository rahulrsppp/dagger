package com.rahul.dagger;

import android.app.Application;

public class MyApplication extends Application {

    private ApplicationComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.create();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}

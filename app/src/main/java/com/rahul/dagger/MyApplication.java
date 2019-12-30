package com.rahul.dagger;

import android.app.Application;

import com.rahul.dagger.di.component.ApplicationComponent;
import com.rahul.dagger.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class MyApplication extends DaggerApplication {


    /*public static ApplicationComponent getAppComponent() {
        return appComponent;
    }*/


    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }


}

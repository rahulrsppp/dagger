package com.rahul.dagger.di.module;

import android.app.Application;
import android.content.Context;

import com.rahul.dagger.di.scope.AppScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppContextModule {

    @AppScope
    @Binds
    abstract Context bindContext(Application application);
}


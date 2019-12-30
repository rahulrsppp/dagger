package com.rahul.dagger.di.module;

import android.app.Activity;
import android.content.Context;

import com.rahul.dagger.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityContextModule {

    private Context context;
    private Activity activity;

    public ActivityContextModule(Activity activity) {
        this.activity = activity;
        this.context = activity;
    }

    @PerActivity
    @Provides
    Context provideContext(){
        return context;
    }

    @PerActivity
    @Provides
    Activity provideActivity(){
        return activity;
    }
}

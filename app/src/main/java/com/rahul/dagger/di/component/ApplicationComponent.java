package com.rahul.dagger.di.component;

import android.app.Application;

import com.rahul.dagger.MyApplication;
import com.rahul.dagger.di.module.ActivityBindingModule;
import com.rahul.dagger.di.module.ActivityContextModule;
import com.rahul.dagger.di.module.ApiModule;
import com.rahul.dagger.di.module.AppContextModule;
import com.rahul.dagger.di.scope.AppScope;
import com.rahul.dagger.di.module.RetrofitModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScope
@Singleton
@Component(modules = {AppContextModule.class, RetrofitModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

   // MainActivityComponent getMainActivityComponent(ActivityContextModule activityContextModule);

    void inject(MyApplication application);



    @Component.Builder
    interface Builder{

        @AppScope
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent  build();
    }
}


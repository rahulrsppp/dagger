package com.rahul.dagger.di.component;

import com.rahul.dagger.di.module.ActivityContextModule;
import com.rahul.dagger.di.scope.PerActivity;
import com.rahul.dagger.ui.main.AdapterModule;
import com.rahul.dagger.ui.main.MainActivity;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;

@PerActivity
@Component(modules = {ActivityContextModule.class/*AdapterModule.class*/})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);


    /*@Subcomponent.Builder
    interface Builder{

        @PerActivity
        @BindsInstance
        Builder application(MainActivity mainActivity);

        MainActivityComponent  build();
    }*/
}

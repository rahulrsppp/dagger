package com.rahul.dagger.di.module;

import android.arch.lifecycle.ViewModel;

import com.rahul.dagger.di.utility.ViewModelKey;
import com.rahul.dagger.ui.main.MainActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.IntoMap;

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel getMainViewModel(MainViewModel mainViewModel);
}

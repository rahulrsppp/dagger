package com.rahul.dagger.ui.main;

import android.content.Context;

import com.rahul.dagger.util.Listeners;
import com.rahul.dagger.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    @PerActivity
    @Provides
    NewsAdapter provideAdapter(Listeners.ItemClickListener context){
        return new NewsAdapter(context);
    }

    @PerActivity
    @Provides
    public Listeners.ItemClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }



}

package com.rahul.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterModule {

    private MainActivity context;

     AdapterModule(MainActivity context){
        this.context = context;
    }

    @Provides
    NewsAdapter provideAdapter(){
        return new NewsAdapter(context);
    }





}

package com.rahul.dagger.di.module;

import com.rahul.dagger.ui.main.APIInterface;
import com.rahul.dagger.CircularInterface;
import com.rahul.dagger.di.scope.AppScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Singleton
    @Provides
    APIInterface getApiInterface(Retrofit retrofit){
        return  retrofit.create(APIInterface.class);
    }

    @Singleton
    @Provides
    CircularInterface getCircularInterface(Retrofit retrofit){
        return  retrofit.create(CircularInterface.class);
    }



}

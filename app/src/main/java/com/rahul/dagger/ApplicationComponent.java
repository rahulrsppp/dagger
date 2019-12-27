package com.rahul.dagger;

import dagger.Component;

@Component(modules = RetrofitModule.class)
public interface ApplicationComponent {

    APIInterface getApiInterface();
}

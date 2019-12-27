package com.rahul.dagger;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class,
modules = AdapterModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}

package com.rahul.dagger.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Scope;
import javax.inject.Singleton;

@Qualifier
public @interface PerActivity {
}

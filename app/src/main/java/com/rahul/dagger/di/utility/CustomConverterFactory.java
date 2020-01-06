package com.rahul.dagger.di.utility;


import com.google.gson.GsonBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CustomConverterFactory extends Converter.Factory {

    @Inject
    public CustomConverterFactory(){}


    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType() == Scalar.class) {
                return ScalarsConverterFactory.create().responseBodyConverter(type, annotations, retrofit);
            }
           else if (annotation.annotationType() == Gson.class) {
                return GsonConverterFactory.create().responseBodyConverter(type, annotations, retrofit);
            }
        }
        return GsonConverterFactory.create().responseBodyConverter(type, annotations, retrofit);
    }
}
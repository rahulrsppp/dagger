package com.rahul.dagger;

import com.rahul.dagger.ui.base.BaseInterface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface CircularInterface  extends BaseInterface {

    @GET("/mobapps/teacher/circularservices")
    Call<String> getCircularData(@Query("academicyearid") String academicyearid);


}

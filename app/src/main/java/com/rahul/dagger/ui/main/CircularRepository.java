package com.rahul.dagger.ui.main;

import com.rahul.dagger.CircularInterface;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public class CircularRepository {

    private final CircularInterface repoService;

    @Inject
    public CircularRepository(CircularInterface repoService) {
        this.repoService = repoService;
    }

    public Single<String> getRepositories(String academicyearid) {
        return repoService.getCircularData(academicyearid);
    }


    public interface CircularInterface{
        @GET("/mobapps/teacher/circularservices")
        Single<String> getCircularData(@Query("academicyearid") String academicyearid);

    }


}

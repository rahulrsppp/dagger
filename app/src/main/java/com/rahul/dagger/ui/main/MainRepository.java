package com.rahul.dagger.ui.main;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class MainRepository {

    private final APIInterface repoService;

    @Inject
    public MainRepository(APIInterface repoService) {
        this.repoService = repoService;
    }

    public Single<String> getRepositories(String url) {
        return repoService.getNewsData(url);
    }


    public interface APIInterface{
        @GET
        Single<String> getNewsData(@Url String url);
    }


}

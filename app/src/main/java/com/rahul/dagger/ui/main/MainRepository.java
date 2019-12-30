package com.rahul.dagger.ui.main;

import javax.inject.Inject;

import io.reactivex.Single;

public class MainRepository {

    private final APIInterface repoService;

    @Inject
    public MainRepository(APIInterface repoService) {
        this.repoService = repoService;
    }

    public Single<String> getRepositories(String url) {
        return repoService.getNewsData(url);
    }


}

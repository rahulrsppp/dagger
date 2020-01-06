package com.rahul.dagger.ui.main;

import com.rahul.dagger.di.utility.Gson;
import com.rahul.dagger.di.utility.Library;
import com.rahul.dagger.di.utility.MessageResponseModel;
import com.rahul.dagger.di.utility.Scalar;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;
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

    public Single<Library> getLibraryBooks() {
        return repoService.getLibraryBook();
    }

    public interface APIInterface{
        @GET @Scalar
        Single<String> getNewsData(@Url String url);

        @GET("/mobapps/management/LibraryService") @Gson
        Single<Library> getLibraryBook();
    }

}

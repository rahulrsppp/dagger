package com.rahul.dagger.ui.main;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface  {

    @GET
    Single<String> getNewsData(@Url String url);


}

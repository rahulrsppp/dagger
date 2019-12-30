package com.rahul.dagger.ui.main;

import com.rahul.dagger.ui.base.BaseInterface;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface extends BaseInterface {

    @GET
    Single<String> getNewsData(@Url String url);


}

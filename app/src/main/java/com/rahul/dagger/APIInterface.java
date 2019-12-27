package com.rahul.dagger;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface {

    @GET
    Call<String> getNewsData(@Url String url);
}

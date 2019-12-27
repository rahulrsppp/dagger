package com.rahul.dagger;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class RetrofitModule {

    private static final int TIMEOUT = 40;

    @Provides
     APIInterface getApiInterface(Retrofit retrofit){
        return  retrofit.create(APIInterface.class);
    }

    @Provides
     OkHttpClient  getOkHttpClient(){
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request originalRequest = chain.request();

                        Request.Builder newRequest = originalRequest.newBuilder();
                        newRequest.build();

                        Request request = newRequest.build();
                        return chain.proceed(request);
                    }
                }).connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();

    }

    @Provides
    Retrofit  getRetrofitInstance(OkHttpClient okHttpClient){
        return new Retrofit.Builder().baseUrl("http://eduinsight.edunexttechnologies.com/").client(okHttpClient).addConverterFactory(ScalarsConverterFactory.create()).build();

    }


}

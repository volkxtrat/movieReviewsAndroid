package com.android.moviereviews.network;

import com.android.moviereviews.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ApiKeyInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        HttpUrl originalUrl = request.url();
        HttpUrl url = request.url().newBuilder()
                .addQueryParameter("api-key", BuildConfig.API_KEY)
                .build();
//        Request newRequest = request.newBuilder().url(url).build();
        request = request.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}

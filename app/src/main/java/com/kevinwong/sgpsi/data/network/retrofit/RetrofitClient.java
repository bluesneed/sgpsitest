package com.huang.huangtest.Data.Network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JiawenHuang on 6/12/17.
 */

public class RetrofitClient {

    private static Retrofit castAPIClient;

    private static String BASE_API = "https://m9llkofj28.execute-api.ap-southeast-1.amazonaws.com/stag/";

    private static void buildCastAPIClient() {
//
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLogInterceptor());

        OkHttpClient okHttpClient = builder.build();

        castAPIClient = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    public static <T> T create(Class<T> service) {
        if (castAPIClient == null)
            buildCastAPIClient();
        return castAPIClient.create(service);
    }

}

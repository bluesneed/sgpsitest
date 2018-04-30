package com.kevinwong.sgpsi.data.network.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kevinwong.sgpsi.data.network.PSIDeserializer;
import com.kevinwong.sgpsi.model.PSIResponse;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

    private static Retrofit castAPIClient;

    private static String BASE_API = "https://api.data.gov.sg/v1/";

    private static void buildCastAPIClient() {
//
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpLogInterceptor());

        OkHttpClient okHttpClient = builder.build();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<PSIResponse>() {}.getType(), new PSIDeserializer())
                .create();

        castAPIClient = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    public static <T> T create(Class<T> service) {
        if (castAPIClient == null)
            buildCastAPIClient();
        return castAPIClient.create(service);
    }

}

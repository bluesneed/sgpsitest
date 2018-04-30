package com.kevinwong.sgpsi.data.network.retrofit;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;


public class HttpLogInterceptor implements Interceptor {

    public static int LEVEL_SIMPLE;

    public static int LEVEL_INTENSIVE;


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        if (request.method().equalsIgnoreCase("POST")) {

            Buffer requestBuffer = new Buffer();
            request.body().writeTo(requestBuffer);
            String body = requestBuffer.readUtf8();

            long t1 = System.nanoTime();
            Log.d("OKHTTP", "↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
            Log.d(
                    "OkHttp", String.format("----> Sending #Post# Request to %s" +
                                    "%n----> Header:   %s" +
                                    "%n----> Body:     %s",
                            request.url(), request.headers(), body));

            Response response = chain.proceed(request);

            MediaType contentType = response.body().contentType();
            String content = response.body().string();

            long t2 = System.nanoTime();
            if ((response.code() / 100) == 2) {
                Log.d("OkHttp", String.format("<---- Received response with code : %s" +
                                "%n<---- Duration:   %.1fms" +
                                "%n<---- Header:     %s" +
                                "%n<---- Content:    %s",
                        String.valueOf(response.code()),
                        (t2 - t1) / 1e6d,
                        response.headers(),
                        content)
                );
            } else {
                Log.e("OkHttp", String.format("<---- Received error response with code : %s"
                                + "%n<---- From: %s"
                                + "%n Content is %s",
                        String.valueOf(response.code()),
                        request.url(),
                        content
                        )
                );
            }

            Log.d("OKHTTP", "↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");

            ResponseBody wrappedBody = ResponseBody.create(contentType, content);
            return response.newBuilder().body(wrappedBody).build();
        } else {

            Log.d("OKHTTP", "↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
            Log.d("OkHttp", String.format("----> Sending #Get# Request to %s" +
                            "%n----> Header:   %s",
                    request.url(), request.headers()));
            Log.d("OKHTTP", "↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");

            return chain.proceed(request);
        }

    }

}
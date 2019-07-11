package com.hudipo.pum_indomaret.api;

import android.util.Base64;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliect {

//    private static final String BASE_URL = "http://172.20.10.3/MyApi3/public/";
   //private static final String BASE_URL = "http://10.7.70.80/MyApi3/public/";
   private static final String BASE_URL = "http://172.20.10.3/MyApi3/public/";
    private static final String AUTH = "Basic " + Base64.encodeToString(("hudipo:161616").getBytes(), Base64.NO_WRAP);

    //singleton instance
    private static RetrofitCliect mInstance;
    //retrofit object
    private Retrofit retrofit;

    private RetrofitCliect(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                Request original = chain.request();

                                Request.Builder requestBuilder = original.newBuilder()
                                        .addHeader("Authorization", AUTH)
                                        .method(original.method(), original.body());

                                Request request = requestBuilder.build();
                                return chain.proceed(request);
                            }
                        }
                ).build();
        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    //syncronize method to get singleton instance

    public static synchronized RetrofitCliect getInstance(){
        if(mInstance == null){
            mInstance = new RetrofitCliect();
        }
        return mInstance;
    }
    //get Api
    public Api getApi(){
        return retrofit.create(Api.class);
    }

}

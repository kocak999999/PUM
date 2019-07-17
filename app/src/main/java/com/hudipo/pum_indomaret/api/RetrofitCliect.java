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

   private static final String BASE_URL = "https://http://jeffapi.hudipo.com/api/";
//    private static final String AUTH = "Basic " + Base64.encodeToString(("hudipo:161616").getBytes(), Base64.NO_WRAP);

    //singleton instance
    private static RetrofitCliect mInstance;
    //retrofit object
    private Retrofit retrofit;

    private RetrofitCliect(){


        retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
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

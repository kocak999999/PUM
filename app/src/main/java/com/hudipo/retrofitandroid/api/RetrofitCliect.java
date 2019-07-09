package com.hudipo.retrofitandroid.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliect {

//    private static final String BASE_URL = "http://172.20.10.3/MyApi3/public/";
   //private static final String BASE_URL = "http://10.7.70.80/MyApi3/public/";
   private static final String BASE_URL = "http://172.20.10.3/MyApi3/public/";
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

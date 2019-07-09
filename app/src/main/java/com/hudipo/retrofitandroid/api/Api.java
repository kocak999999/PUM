package com.hudipo.retrofitandroid.api;

import com.hudipo.retrofitandroid.model.DefaultResponse;
import com.hudipo.retrofitandroid.model.DepartmentResponse;
import com.hudipo.retrofitandroid.model.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> createuser(
            @Field("emp_name") String emp_name,
            @Field("emp_email") String emp_email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userlogin(
            @Field("emp_email") String emp_email,
            @Field("password") String password
    );

    @GET("alldepartments")
    Call<DepartmentResponse> getDepartments();



}

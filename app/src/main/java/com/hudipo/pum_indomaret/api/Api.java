package com.hudipo.pum_indomaret.api;

import com.hudipo.pum_indomaret.model.DefaultResponse;
import com.hudipo.pum_indomaret.model.DepartmentResponse;
import com.hudipo.pum_indomaret.model.DocumentsResponse;
import com.hudipo.pum_indomaret.model.LoginResponse;
import com.hudipo.pum_indomaret.model.UsersResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("register")
    Call<DefaultResponse> register(
            @Field("emp_num") String emp_num,
            @Field("password") String password,
            @Field("pin") String pin
    );


    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("emp_num") String emp_email,
            @Field("password") String password
    );

    @GET("documents")
    Call<DocumentsResponse> getDocument();

    @GET("getdept")
    Call<DepartmentResponse> getDepartments();

//    @GET("gettrxtype")
//    Call<TrxResponse> getDepartment();



//    @GET("inboxs")
//    Call<InboxsResponse> getInbox();






}

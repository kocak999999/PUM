package com.hudipo.pum_indomaret.activities.request;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.activities.approval.ApprovalActivity;
import com.hudipo.pum_indomaret.adapters.DocumentsAdapter;
import com.hudipo.pum_indomaret.api.Api;
import com.hudipo.pum_indomaret.api.RetrofitCliect;
import com.hudipo.pum_indomaret.model.Document;
import com.hudipo.pum_indomaret.model.DocumentsResponse;
import com.hudipo.pum_indomaret.model.UsersResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestDocument extends AppCompatActivity {

    private RecyclerView rcv_doc_detail_port;
    private DocumentsAdapter adapter;
   private ArrayList<Document> documentArrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_document);
        view();
    }

    private void view() {
        rcv_doc_detail_port = (RecyclerView) findViewById(R.id.rcv_doc_detail_port);
        rcv_doc_detail_port.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rcv_doc_detail_port.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jeffapi.hudipo.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
//        Call<DocumentsResponse> call = RetrofitCliect.getInstance().getApi().getDocument();
        Call<DocumentsResponse> call = api.getDocument();
        call.enqueue(new Callback<DocumentsResponse>() {
            @Override
            public void onResponse(Call<DocumentsResponse> call, Response<DocumentsResponse> response) {
                DocumentsResponse documentsResponse = response.body();
                documentArrayList = new ArrayList<>(Arrays.asList(documentsResponse.getDocuments()));
                adapter = new DocumentsAdapter(documentArrayList);
                rcv_doc_detail_port.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<DocumentsResponse> call, Throwable t) {

            }
        });
    }


}

package com.hudipo.pum_indomaret.activities.approval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.adapters.ApprovalsAdapter;
import com.hudipo.pum_indomaret.model.ApprovalList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ApprovalActivity extends AppCompatActivity {

    private RecyclerView rcv_approval;
    private ApprovalsAdapter approvalsAdapter;
    private List<ApprovalList> approvalLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval);

        rcv_approval = (RecyclerView) findViewById(R.id.rcv_approval);
//        rcv_approval.hasFixedSize();
//        rcv_approval.setLayoutManager(new LinearLayoutManager(this));
//        approvalLists = new ArrayList<>();
//        Call<UsersResponse> call = RetrofitClient.getInstance().getApi().getUsers();


    }
}

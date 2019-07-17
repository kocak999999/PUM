package com.hudipo.pum_indomaret.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.adapters.ApprovalsAdapter;
import com.hudipo.pum_indomaret.model.Approval;

import java.util.ArrayList;

public class ApprovalFragment extends Fragment {

    public ArrayList<Approval> DataApproval = new ArrayList<Approval>();



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_approval, container, false);

    }

    @Override
    public void onStart() {

        super.onStart();
//        TextView tvTest = (TextView) getActivity().findViewById(R.id.tvTest);
//        tvTest.setText("ini hasil");
        RecyclerView rcv_approval = (RecyclerView) getActivity().findViewById(R.id.rcv_approval);

        setListData();
        ApprovalsAdapter approvalsAdapter = new ApprovalsAdapter(getActivity(), DataApproval);

        rcv_approval.setAdapter(approvalsAdapter);
    }

    public void setListData()
    {

        for (int i = 0; i < 11; i++) {

            final Approval approval = new Approval(
                    "pum_number "+i
                    ,"name"+i
                    ,"amount"+i);

            DataApproval.add(approval);
        }

    }
}

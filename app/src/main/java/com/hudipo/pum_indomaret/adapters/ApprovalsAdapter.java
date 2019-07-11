package com.hudipo.pum_indomaret.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.model.ApprovalList;

import java.util.List;

public class ApprovalsAdapter extends RecyclerView.Adapter<ApprovalsAdapter.ApprovalsViewHolder> {


    private Context context;
    private List<ApprovalList> approvalLists;

    public ApprovalsAdapter(Context context, List<ApprovalList> approvalLists) {
        this.context = context;
        this.approvalLists = approvalLists;
    }

    @NonNull
    @Override
    public ApprovalsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_rcv_approval, viewGroup, false);
        return new ApprovalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovalsViewHolder approvalsViewHolder, int i) {

        ApprovalList approvalList = approvalLists.get(i);
        approvalsViewHolder.tv_pum_number_approval.setText(approvalList.getStr_pum_number_approval());
        approvalsViewHolder.tv_pum_name_approval.setText(approvalList.getStr_pum_name_approval());
        approvalsViewHolder.tv_pum_amount_approval.setText(approvalList.getStr_pum_amount_approval());

    }

    @Override
    public int getItemCount() {
        return approvalLists.size();
    }

    class ApprovalsViewHolder extends RecyclerView.ViewHolder{

        TextView tv_pum_number_approval;
        TextView tv_pum_name_approval;
        TextView tv_pum_amount_approval;
        public ApprovalsViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_pum_number_approval = (TextView) itemView.findViewById(R.id.tv_pum_number_approval);
            tv_pum_name_approval = (TextView) itemView.findViewById(R.id.tv_pum_name_approval);
            tv_pum_amount_approval = (TextView) itemView.findViewById(R.id.tv_pum_amount_approval);

        }
    }
}

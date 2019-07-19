package com.hudipo.pum_indomaret.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;

import com.hudipo.pum_indomaret.model.Approval;

import java.util.List;


public class ApprovalsAdapter extends RecyclerView.Adapter<ApprovalsAdapter.ApprovalsViewHolder> {

    private Context context;
    private List<Approval> approvals;

    public ApprovalsAdapter(Context context, List<Approval> approvals) {
        this.context = context;
        this.approvals = approvals;
    }

    @NonNull
    @Override
    public ApprovalsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cell_approval, parent, false);
        return new ApprovalsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovalsViewHolder holder, int position) {
        Approval approval = approvals.get(position);

        holder.tv_pum_number_approval.setText(approval.getStr_pum_number_approval());
        holder.tv_pum_name_approval.setText(approval.getStr_pum_name_approval());
        holder.tv_pum_amount_approval.setText(approval.getStr_pum_amount_approval());


    }

    @Override
    public int getItemCount() {
        return approvals.size();
    }

    class ApprovalsViewHolder extends RecyclerView.ViewHolder {

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

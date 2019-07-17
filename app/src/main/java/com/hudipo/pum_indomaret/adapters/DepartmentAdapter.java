package com.hudipo.pum_indomaret.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.model.Department;


import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder> {

    private Context context;
    private List<Department> departmentList;

    public DepartmentAdapter(Context context, List<Department> departmentList) {
        this.context = context;
        this.departmentList = departmentList;
    }


    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_department,viewGroup, false);
        return new DepartmentViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        Department department = departmentList.get(position);

        holder.tv_dept_name.setText(department.getNAME());

    }



    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    class DepartmentViewHolder extends RecyclerView.ViewHolder {

        TextView tv_dept_name;

        public DepartmentViewHolder(View itemView) {
            super(itemView);

            tv_dept_name = itemView.findViewById(R.id.tv_dept_name);

        }
    }
}

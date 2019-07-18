//package com.hudipo.pum_indomaret.adapters;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//
//import com.hudipo.pum_indomaret.R;
//import com.hudipo.pum_indomaret.model.User;
//
//import java.util.List;
//
//public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {
//
//    private Context mCtx;
//    private List<User> userList;
//
//    public UsersAdapter(Context mCtx, List<User> userList) {
//        this.mCtx = mCtx;
//        this.userList = userList;
//    }
//
//    @NonNull
//    @Override
//    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(mCtx).inflate(R.layout., parent, false);
//        return new UsersViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
//        User user = userList.get(position);
//
//        holder.tv_emp_num.setText(user.getEmp_num());
//        holder.tv_emp_name.setText(user.getEmp_name());
//    }
//
//    @Override
//    public int getItemCount() {
//        return userList.size();
//    }
//
//    class UsersViewHolder extends RecyclerView.ViewHolder {
//
//        TextView tv_emp_num;
//        TextView tv_emp_name;
//
//        public UsersViewHolder(View itemView) {
//            super(itemView);
//
////            tv_emp_num = itemView.findViewById(R.id.textViewName);
////            tv_emp_name = itemView.findViewById(R.id.textViewEmail);
//
//        }
//    }
//}

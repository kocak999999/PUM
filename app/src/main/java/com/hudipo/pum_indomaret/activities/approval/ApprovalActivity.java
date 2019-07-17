package com.hudipo.pum_indomaret.activities.approval;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.adapters.ApprovalsAdapter;
import com.hudipo.pum_indomaret.fragments.ApprovalFragment;
import com.hudipo.pum_indomaret.fragments.ApprovalHistoryFragment;
import com.hudipo.pum_indomaret.model.Approval;

import java.util.List;

public class ApprovalActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rcv_approval;
    private ApprovalsAdapter approvalsAdapter;
    private List<Approval> approvals;
    BottomNavigationView menu_bottom_approval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval);


        menu_bottom_approval = (BottomNavigationView)findViewById(R.id.bottom_menu_approval);
        menu_bottom_approval.setOnNavigationItemSelectedListener(this);
//        rcv_approval = (RecyclerView) findViewById(R.id.rcv_approval);
//        rcv_approval.hasFixedSize();
//        rcv_approval.setLayoutManager(new LinearLayoutManager(this));
//        approvals = new ArrayList<>();
//        Call<UsersResponse> call = RetrofitClient.getInstance().getApi().getUsers();

        displayFragment(new ApprovalFragment());

    }

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_approval, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch(menuItem.getItemId()){
            case R.id.menu_approval:
                fragment = new ApprovalFragment();
                break;
            case R.id.menu_history:
                fragment = new ApprovalHistoryFragment();
                break;
        }

        if(fragment != null){
            displayFragment(fragment);
        }


        return false;
    }
}

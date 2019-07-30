package com.hudipo.pum_indomaret.activities.request;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;

public class RequestDetailActivity extends AppCompatActivity {

    TextView tv_emp_name_detail;
    TextView tv_emp_dep_detail;
    TextView tv_use_date_detail;
    TextView tv_resp_name_detail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);
    }
}

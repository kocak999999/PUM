package com.hudipo.pum_indomaret.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.activities.approval.ApprovalActivity;
import com.hudipo.pum_indomaret.activities.inbox.InboxActivity;
import com.hudipo.pum_indomaret.activities.request.RequestActivity;
import com.hudipo.pum_indomaret.activities.setting.SettingActivity;
import com.hudipo.pum_indomaret.model.User;
import com.hudipo.pum_indomaret.storage.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    ImageView profile_img;
    TextView tv_emp_name;
    TextView tv_emp_num;

    CardView btn_request;
    CardView btn_approval;
    CardView btn_inbox;
    CardView btn_responsibility;
    CardView btn_setting;
    CardView btn_report;

    ImageView request, approval,inbox, respons, setting, report, nextfeatures, nextfeatures2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profile_img = findViewById(R.id.profile_img);

        tv_emp_name = findViewById(R.id.tv_emp_name);
        tv_emp_num = findViewById(R.id.tv_emp_num);

        request = findViewById(R.id.picRequest);
        Glide.with(this).load(R.drawable.ic_request).into(request);
        approval = findViewById(R.id.picApprove);
        Glide.with(this).load(R.drawable.ic_approval).into(approval);
        inbox = findViewById(R.id.picInbox);
        Glide.with(this).load(R.drawable.ic_envelope).into(inbox);
        respons = findViewById(R.id.picRespon);
        Glide.with(this).load(R.drawable.ic_resp).into(respons);
        setting = findViewById(R.id.picSetting);
        Glide.with(this).load(R.drawable.ic_setting).into(setting);
        report = findViewById(R.id.picReport);
        Glide.with(this).load(R.drawable.ic_report).into(report);
        nextfeatures = findViewById(R.id.picNextFeatures);
        Glide.with(this).load(R.drawable.ic_idea).into(nextfeatures);
        nextfeatures2 = findViewById(R.id.picNextFeatures2);
        Glide.with(this).load(R.drawable.ic_idea).into(nextfeatures2);




        btn_request = (CardView) findViewById(R.id.btn_request);
        btn_approval = (CardView) findViewById(R.id.btn_approval);
        btn_inbox = (CardView) findViewById(R.id.btn_inbox);
        btn_responsibility = (CardView) findViewById(R.id.btn_responsibility);
        btn_setting = (CardView) findViewById(R.id.btn_setting);
        btn_report = (CardView) findViewById(R.id.btn_report);


        User user = SharedPrefManager.getInstance(this).getUser();
        tv_emp_name.setText("Welcome ! \n" + user.getNAME());
        tv_emp_num.setText(user.getEMP_NUM());


        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RequestActivity.class);
                startActivity(intent);

            }
        });


        btn_approval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ApprovalActivity.class);
                startActivity(intent);
            }
        });

        btn_inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InboxActivity.class);
                startActivity(intent);

            }
        });

        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);

            }
        });

        //profile photo
        profile_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);

            }
        });


    }

//    private void logout() {
//        SharedPrefManager.getInstance(this).clear();
//        Intent intent = new Intent(this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//    }


    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, RegisterActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}

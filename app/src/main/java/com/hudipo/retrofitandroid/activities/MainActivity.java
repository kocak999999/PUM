package com.hudipo.retrofitandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hudipo.retrofitandroid.R;
import com.hudipo.retrofitandroid.activities.request.RequestActivity;
import com.hudipo.retrofitandroid.model.User;
import com.hudipo.retrofitandroid.storage.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    private TextView tv_emp_id;
    private TextView tv_emp_name;
    private TextView tv_emp_email;
    Button btn_logout;
    CardView btn_request;
    CardView btn_approval;
    CardView btn_inbox;
    CardView btn_responsibility;
    CardView btn_setting;
    CardView btn_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       tv_emp_id = findViewById(R.id.tv_emp_id);
        tv_emp_name= findViewById(R.id.tv_emp_name);
        tv_emp_email = findViewById(R.id.tv_emp_email);

        btn_request = (CardView) findViewById(R.id.btn_request);
        btn_approval = (CardView) findViewById(R.id.btn_approval);
        btn_inbox = (CardView) findViewById(R.id.btn_inbox);
        btn_responsibility = (CardView) findViewById(R.id.btn_responsibility);
        btn_setting = (CardView) findViewById(R.id.btn_setting);
        btn_report = (CardView) findViewById(R.id.btn_report);

        btn_logout = findViewById(R.id.btn_logout);

        User user= SharedPrefManager.getInstance(this).getUser();

        tv_emp_id.setText(""+user.getEmp_id());
        tv_emp_name.setText(user.getEmp_name());
        tv_emp_email.setText(user.getEmp_email());


        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RequestActivity.class);
                startActivity(intent);

            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               logout();
            }
        });
    }

    private void logout() {
        SharedPrefManager.getInstance(this).clear();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }


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

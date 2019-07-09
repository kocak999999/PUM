package com.hudipo.retrofitandroid.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hudipo.retrofitandroid.R;
import com.hudipo.retrofitandroid.api.RetrofitCliect;
import com.hudipo.retrofitandroid.model.DefaultResponse;
import com.hudipo.retrofitandroid.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_emp_name_regis;
    private EditText et_emp_email_regis;
    private EditText et_pass_regis;
    private TextView tv_login_in_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_emp_name_regis = findViewById(R.id.et_emp_name_regis);
        et_emp_email_regis = findViewById(R.id.et_emp_email_regis);
        et_pass_regis = findViewById(R.id.et_pass_regis);
        tv_login_in_regis = findViewById(R.id.tv_login_in_regis);

        findViewById(R.id.btn_regis).setOnClickListener(this);
        findViewById(R.id.tv_login_in_regis).setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void userSignup() {
        String str_emp_name = et_emp_name_regis.getText().toString().trim();
        String str_emp_email = et_emp_email_regis.getText().toString().trim();
        String str_pass = et_pass_regis.getText().toString().trim();

        if (str_emp_email.isEmpty()) {
            et_emp_email_regis.setError("Email is Required !");
            et_emp_email_regis.requestFocus();
            return;
        }

        if (Patterns.EMAIL_ADDRESS.matcher(str_emp_email).matches()) {
            et_emp_name_regis.setError("Email a valid Email ");
            et_emp_name_regis.requestFocus();
            return;
        }

        if (str_pass.isEmpty()) {
            et_pass_regis.setError("Password Required");
            et_pass_regis.requestFocus();
            return;

        }

        if (str_pass.length() < 8) {
            et_pass_regis.setError("Password must be at least 8 character long !");
            et_pass_regis.requestFocus();
            return;

        }

        if (str_emp_name.isEmpty()) {
            et_emp_name_regis.setError("Name is required !");
            et_emp_name_regis.requestFocus();
            return;

        }

        Call<DefaultResponse> call = RetrofitCliect
                .getInstance()
                .getApi()
                .createuser(str_emp_name, str_emp_email, str_pass);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if(response.code() == 201){
                    DefaultResponse dr = response.body();
                    Toast.makeText(RegisterActivity.this,dr.getMsg(),Toast.LENGTH_LONG).show();

                }else if(response.code()==422){
                    Toast.makeText(RegisterActivity.this,"User already Exist",Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_regis:
                userSignup();
                break;
            case R.id.tv_login_in_regis:
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }

    }
}

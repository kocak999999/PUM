package com.hudipo.pum_indomaret.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.api.RetrofitCliect;
import com.hudipo.pum_indomaret.model.LoginResponse;
import com.hudipo.pum_indomaret.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_emp_email_login;
    private EditText et_pass_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_emp_email_login = (EditText) findViewById(R.id.et_emp_email_login);
        et_pass_login = (EditText)findViewById(R.id.et_pass_login);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.tv_signup_in_login_page).setOnClickListener(this);

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

    private void userLogin() {
        String str_emp_email_login = et_emp_email_login.getText().toString().trim();
        String str_pass_login = et_pass_login.getText().toString().trim();

        if (str_emp_email_login.isEmpty()) {
            et_emp_email_login.setError("Email is Required !");
            et_emp_email_login.requestFocus();
            return;
        }

        if (Patterns.EMAIL_ADDRESS.matcher(str_emp_email_login).matches()) {
            et_emp_email_login.setError("Email a valid Email ");
            et_emp_email_login.requestFocus();
            return;
        }

        if (str_pass_login.isEmpty()) {
            et_pass_login.setError("Password Required");
            et_pass_login.requestFocus();
            return;

        }

        if (str_pass_login.length() < 8) {
            et_pass_login.setError("Password must be at least 8 character long !");
            et_pass_login.requestFocus();
            return;

        }
        Call<LoginResponse> call = RetrofitCliect
                .getInstance().getApi().userlogin(str_emp_email_login, str_pass_login);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               LoginResponse loginResponse = response.body();

                    if(!loginResponse.isError()){
                        //save user and open profile
                        SharedPrefManager.getInstance(LoginActivity.this)
                                .saveUser(loginResponse.getUser());

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);


                    }else{
                        Toast.makeText(LoginActivity.this,loginResponse.getMessage(),Toast.LENGTH_LONG).show();
                    }


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                userLogin();
                break;
            case R.id.tv_signup_in_login_page:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}

package com.hudipo.pum_indomaret.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.api.RetrofitCliect;
import com.hudipo.pum_indomaret.model.DefaultResponse;
import com.hudipo.pum_indomaret.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_emp_num_regis;
    private EditText et_pass_regis;
    private EditText et_pin_regis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_emp_num_regis = findViewById(R.id.et_emp_num_regis);
        et_pass_regis = findViewById(R.id.et_pass_regis);
        et_pin_regis = findViewById(R.id.et_pin_regis);

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

    private void userRegis() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering your ID...");
        progressDialog.show();

        String str_emp_num = et_emp_num_regis.getText().toString().trim();
        String str_pass = et_pass_regis.getText().toString().trim();
        String str_pin = et_pin_regis.getText().toString().trim();

        if (str_emp_num.isEmpty()) {
            et_emp_num_regis.setError("NIK is required !");
            et_emp_num_regis.requestFocus();
            return;

        }

        if (str_emp_num.length() < 10) {
            et_emp_num_regis.setError("NIK must be at least 10 character long !");
            et_emp_num_regis.requestFocus();
            return;

        }

        if (str_pass.isEmpty()) {
            et_pass_regis.setError("Password Required");
            et_pass_regis.requestFocus();
            return;

        }


        if (str_pass.length() < 6) {
            et_pass_regis.setError("Password must be at least 6 character long !");
            et_pass_regis.requestFocus();
            return;

        }

        if (str_pin.isEmpty()) {
            et_pin_regis.setError("PIN Required");
            et_pin_regis.requestFocus();
            return;

        }
        if (str_pin.length() < 8) {
            et_pass_regis.setError("PIN must be at least 8 character long !");
            et_pass_regis.requestFocus();
            return;

        }




        Call<DefaultResponse> call = RetrofitCliect
                .getInstance()
                .getApi()
                .register(str_emp_num, str_pass,str_pin);

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
                userRegis();
                break;
            case R.id.tv_login_in_regis:
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }

    }
}

package com.hudipo.pum_indomaret.activities.request;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.activities.RegisterActivity;
import com.hudipo.pum_indomaret.adapters.DepartmentAdapter;
import com.hudipo.pum_indomaret.api.RetrofitCliect;
import com.hudipo.pum_indomaret.model.DefaultResponse;
import com.hudipo.pum_indomaret.model.Department;
import com.hudipo.pum_indomaret.model.DepartmentResponse;
import com.hudipo.pum_indomaret.model.User;
import com.hudipo.pum_indomaret.storage.SharedPrefManager;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestActivity extends AppCompatActivity {
    //declaration
    private static final String STATE_RESULT = "state_result";
    TextView tv_emp_name_request;
    Spinner sp_emp_dep_request;
    private Department[] departments;
    String str_dep_selected;
    ImageButton ibtn_use_date_request;
    ImageButton ibtn_resp_date_request;
    TextView tv_use_date_request;
    TextView tv_resp_date_request;
    Button btn_next_request;
    private int mYear, mMonth, mDay;
    Calendar c;

    String str_emp_name;
    String strtgl;
    String strtgl2;


    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        tv_emp_name_request = (TextView) findViewById(R.id.tv_emp_name_request);
        sp_emp_dep_request = (Spinner) findViewById(R.id.sp_emp_dep_request);
        ibtn_use_date_request = (ImageButton) findViewById(R.id.ibtn_use_date_request);
        ibtn_resp_date_request = (ImageButton) findViewById(R.id.ibtn_resp_date_request);
        tv_use_date_request = (TextView) findViewById(R.id.tv_use_date_request);
        tv_resp_date_request = (TextView) findViewById(R.id.tv_resp_date_request);
        btn_next_request = (Button) findViewById(R.id.btn_next_request);

        User user = SharedPrefManager.getInstance(this).getUser();
        tv_emp_name_request.setText(user.getNAME());

        //spinner
        sp_emp_dep_request.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str_dep_selected = departments[position].getName() +"-"+ departments[position].getDescription();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c = Calendar.getInstance();
        strtgl = "Use Date";
        strtgl2 = "Responsibility Date";
        tv_use_date_request.setText(strtgl);
        tv_resp_date_request.setText(strtgl2);

        ibtn_use_date_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RequestActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String strbulan;
                                String strtanggal;

                                if (monthOfYear < 9) {
                                    strbulan = "0" + String.valueOf(monthOfYear + 1);
                                } else {
                                    strbulan = String.valueOf(monthOfYear + 1);
                                }

                                if (dayOfMonth < 10) {
                                    strtanggal = "0" + String.valueOf(dayOfMonth);
                                } else {
                                    strtanggal = String.valueOf(dayOfMonth);
                                }
                                strtgl = year + "-" + strbulan + "-" + strtanggal;
                                tv_use_date_request.setText(strtgl);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        ibtn_resp_date_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(RequestActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                String strbulan;
                                String strtanggal;

                                if (monthOfYear < 9) {
                                    strbulan = "0" + String.valueOf(monthOfYear + 1);
                                } else {
                                    strbulan = String.valueOf(monthOfYear + 1);
                                }

                                if (dayOfMonth < 10) {
                                    strtanggal = "0" + String.valueOf(dayOfMonth);
                                } else {
                                    strtanggal = String.valueOf(dayOfMonth);
                                }
                                strtgl2 = year + "-" + strbulan + "-" + strtanggal;
                                tv_resp_date_request.setText(strtgl2);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        btn_next_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_emp_name = tv_emp_name_request.getText().toString();
                Intent intent = new Intent(RequestActivity.this, Request2Activity.class);
                startActivity(intent);
            }
        });

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tv_use_date_request.setText(result);
            tv_resp_date_request.setText(result);
        }

        subGetDepartments();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tv_use_date_request.getText().toString());
        outState.putString(STATE_RESULT, tv_resp_date_request.getText().toString());

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Quit ? ");
        builder.setMessage("Are You Sure Back to Menu? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                RequestActivity.super.onBackPressed();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.show();
    }

    private void subGetDepartments() {
        Call<DepartmentResponse> call = RetrofitCliect.getInstance().getApi().getDepartments();
        call.enqueue(new Callback<DepartmentResponse>() {
            @Override
            public void onResponse(Call<DepartmentResponse> call, Response<DepartmentResponse> response) {
                departments = response.body().getDepartments();

                Toast.makeText(RequestActivity.this, departments[1].getName(), Toast.LENGTH_LONG).show();
                DepartmentAdapter adapter = new DepartmentAdapter(RequestActivity.this, departments);
                sp_emp_dep_request.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DepartmentResponse> call, Throwable t) {

                Toast.makeText(RequestActivity.this, "Error Message", Toast.LENGTH_LONG).show();

            }
        });


    }

    private void sendReqEmp() {

        String str_emp_name = tv_emp_name_request.getText().toString().trim();
        String str_emp_dept = sp_emp_dep_request.getSelectedItem().toString().trim();
        String str_use_date = tv_use_date_request.getText().toString().trim();
        String str_resp_date = tv_resp_date_request.getText().toString().trim();

        if (str_emp_name.isEmpty()) {
            tv_emp_name_request.setError("Name is required !");
            tv_emp_name_request.requestFocus();
            return;

        }
        if (str_emp_dept.equals("--Select Your Department--")) {
            sp_emp_dep_request.setPrompt("Choose Your Department");
            sp_emp_dep_request.requestFocus();
            return;

        }
        if (str_use_date.isEmpty()) {
            tv_use_date_request.setError("Use Date is Required");
            tv_use_date_request.requestFocus();
            return;

        }

        if (str_resp_date.isEmpty()) {
            tv_resp_date_request.setError("Resp Date is Required");
            tv_resp_date_request.requestFocus();
            return;

        }


//        Call<DefaultResponse> call = RetrofitCliect
//                .getInstance()
//                .getApi()
//                .register(str_emp_num, str_pass, str_pin);

//        call.enqueue(new Callback<DefaultResponse>() {
//            @Override
//            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
//                if(response.code() == 201){
//                    DefaultResponse dr = response.body();
//                    Toast.makeText(RegisterActivity.this, dr.getMsg(),Toast.LENGTH_LONG).show();
//                }else if (response.code() == 422){
//                    Toast.makeText(RegisterActivity.this, "User Already Exist",Toast.LENGTH_LONG).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DefaultResponse> call, Throwable t) {
//
//            }
//        });

    }
}


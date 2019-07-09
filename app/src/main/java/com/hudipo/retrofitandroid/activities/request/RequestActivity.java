package com.hudipo.retrofitandroid.activities.request;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hudipo.retrofitandroid.R;
import com.hudipo.retrofitandroid.activities.MainActivity;
import com.hudipo.retrofitandroid.adapters.CustomGridAdapter;
import com.hudipo.retrofitandroid.adapters.DepartmentAdapter;
import com.hudipo.retrofitandroid.api.RetrofitCliect;
import com.hudipo.retrofitandroid.model.Department;
import com.hudipo.retrofitandroid.model.DepartmentResponse;
import com.hudipo.retrofitandroid.model.LoginResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RequestActivity extends AppCompatActivity {

    TextView tv_emp_name_request;
    Spinner sp_emp_dep_request;
    ImageButton ibtn_start_date_request;
    ImageButton ibtn_end_date_request;

    TextView tv_start_date_request;
    TextView tv_end_date_request;

    Button btn_next_request;

    private int mYear, mMonth, mDay, mHour, mMinute;
    Calendar c;
    SimpleDateFormat df2;

    String str_emp_name;
    String str_sp_emp_dep;
    String strtgl;
    String strtgl2;
    List<Department> listDepartment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        tv_emp_name_request = (TextView) findViewById(R.id.tv_emp_name_request);
        sp_emp_dep_request = (Spinner) findViewById(R.id.sp_emp_dep_request);
        ibtn_start_date_request = (ImageButton) findViewById(R.id.ibtn_start_date_request);
        ibtn_end_date_request = (ImageButton) findViewById(R.id.ibtn_end_date_request);

        tv_start_date_request = (TextView) findViewById(R.id.tv_start_date_request);
        tv_end_date_request = (TextView) findViewById(R.id.tv_end_date_request);
        btn_next_request = (Button) findViewById(R.id.btn_next_request);

        c = Calendar.getInstance();
        df2 = new SimpleDateFormat("yyyy-MM-dd");
        strtgl = df2.format(c.getTime());
        strtgl2 = df2.format(c.getTime());
        tv_start_date_request.setText(strtgl);
        tv_end_date_request.setText(strtgl2);

        ibtn_start_date_request.setOnClickListener(new View.OnClickListener() {
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
                                tv_start_date_request.setText(strtgl);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        ibtn_end_date_request.setOnClickListener(new View.OnClickListener() {
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
                                tv_end_date_request.setText(strtgl2);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        btn_next_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_emp_name = tv_emp_name_request.getText().toString();
                str_sp_emp_dep = "HRD";

                Intent intent = new Intent(RequestActivity.this, Request2Activity.class);
                intent.putExtra("kirimnama",str_emp_name);
                intent.putExtra("kiridept",str_sp_emp_dep);
                intent.putExtra("kirimtanggal1",strtgl);
                intent.putExtra("kirimtanggal2",strtgl2);

                startActivity(intent);
            }
        });

     subGetDepartments();


    }

    private void subGetDepartments() {
        Call<DepartmentResponse> call = RetrofitCliect.getInstance().getApi().getDepartments();



        call.enqueue(new Callback<DepartmentResponse>() {
            @Override
            public void onResponse(Call<DepartmentResponse> call, Response<DepartmentResponse> response) {

                listDepartment = response.body().getDepartments();

                Toast.makeText(RequestActivity.this,listDepartment.get(0).getNAME(),Toast.LENGTH_LONG).show();
                CustomGridAdapter adapter = new CustomGridAdapter(RequestActivity.this, listDepartment);
                sp_emp_dep_request.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<DepartmentResponse> call, Throwable t) {

                Toast.makeText(RequestActivity.this,"Error Messsage",Toast.LENGTH_LONG).show();

            }
        });


    }
}


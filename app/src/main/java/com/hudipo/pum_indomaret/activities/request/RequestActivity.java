package com.hudipo.pum_indomaret.activities.request;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
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

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.adapters.DocumentsAdapter;
import com.hudipo.pum_indomaret.model.Department;
import com.hudipo.pum_indomaret.model.Document;
import com.hudipo.pum_indomaret.model.User;
import com.hudipo.pum_indomaret.storage.SharedPrefManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class RequestActivity extends AppCompatActivity {
    //declaration
    TextView tv_emp_name_request;
    Spinner sp_emp_dep_request;
    private DocumentsAdapter adapter;
    private ArrayList<Document> documentArrayList;
    String[]dep;
    ImageButton ibtn_use_date_request;
    ImageButton ibtn_resp_date_request;
    TextView tv_use_date_request;
    TextView tv_resp_date_request;
    Button btn_next_request;


    private int mYear, mMonth, mDay;
    Calendar c;
    SimpleDateFormat df2;

    String str_emp_name;
    String str_sp_emp_dep;
    String strtgl;
    String strtgl2;




    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        tv_emp_name_request = (TextView) findViewById(R.id.tv_emp_name_request);
        sp_emp_dep_request = (Spinner) findViewById(R.id.sp_emp_dep_request);
        dep = getResources().getStringArray(R.array.dep_name);
        ArrayAdapter depAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dep);
        depAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_emp_dep_request.setAdapter(depAdapter);

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
                Toast.makeText(RequestActivity.this,dep[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        c = Calendar.getInstance();
        df2 = new SimpleDateFormat("yyyy-MM-dd");
        strtgl = df2.format(c.getTime());
        strtgl2 = df2.format(c.getTime());
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
                str_sp_emp_dep = "HRD";

                Intent intent = new Intent(RequestActivity.this, Request2Activity.class);
                intent.putExtra("kirimnama",str_emp_name);
                intent.putExtra("kiridept",str_sp_emp_dep);
                intent.putExtra("kirimtanggal1",strtgl);
                intent.putExtra("kirimtanggal2",strtgl2);

                startActivity(intent);
            }
        });

//     subGetDepartments();


    }

//    private void subGetDepartments() {
//        Call<DepartmentResponse> call = RetrofitCliect.getInstance().getApi().getDepartments();
//
//
//
//        call.enqueue(new Callback<DepartmentResponse>() {
//            @Override
//            public void onResponse(Call<DepartmentResponse> call, Response<DepartmentResponse> response) {
//
//                listDepartment = response.body().getDepartments();
//
//                Toast.makeText(RequestActivity.this,listDepartment.get(0).getNAME(),Toast.LENGTH_LONG).show();
//                CustomGridAdapter adapter = new CustomGridAdapter(RequestActivity.this, listDepartment);
//                sp_emp_dep_request.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<DepartmentResponse> call, Throwable t) {
//
//                Toast.makeText(RequestActivity.this,"Error Message",Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//
//    }
}


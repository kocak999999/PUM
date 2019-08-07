package com.hudipo.pum_indomaret.activities.request;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


import com.hudipo.pum_indomaret.R;


public class Request3Activity extends AppCompatActivity implements View.OnClickListener {

    Spinner sp_trx_request3;
    EditText et_description_request3;
    TextView tv_currency_request3;
    EditText et_amount_request3;
    TextView tv_upload_request3;
    ImageButton ibtn_doc_detail_request3;
    Button btn_submit_request3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request3);

        sp_trx_request3 = findViewById(R.id.sp_trx_request3);
        et_description_request3 = findViewById(R.id.et_description_request3);
        tv_currency_request3 = findViewById(R.id.tv_currency_request3);
        et_amount_request3 = findViewById(R.id.et_amount_request3);
        tv_upload_request3 = findViewById(R.id.tv_upload_request3);
        ibtn_doc_detail_request3 = findViewById(R.id.ibtn_doc_detail_request3);
        ibtn_doc_detail_request3.setOnClickListener(this);
        btn_submit_request3 = findViewById(R.id.btn_submit_request3);
        btn_submit_request3.setOnClickListener(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ibtn_doc_detail_request3.setEnabled(false);

            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        } else {
            ibtn_doc_detail_request3.setEnabled(true);

        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ibtn_doc_detail_request3.setEnabled(true);
            }
        }
    }

    private void saveallrequest() {
        Intent intent = new Intent(Request3Activity.this, RequestDetailActivity.class);
        startActivity(intent);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ibtn_doc_detail_request3:
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
                break;
            case R.id.btn_submit_request3:
                saveallrequest();
                break;

        }
    }
}

package com.hudipo.retrofitandroid.activities.request;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.hudipo.retrofitandroid.R;

public class Request3Activity extends AppCompatActivity {

    Spinner sp_trx_request3;
    EditText et_description_request3;
    TextView tv_currency_request3;
    EditText et_amount_request3;
    TextView tv_upload_request3;
    ImageButton ibtn_doc_detail_request;
    Button btn_submit_request3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request3);

        sp_trx_request3 = (Spinner)findViewById(R.id.sp_trx_request3);
        et_description_request3 = (EditText)findViewById(R.id.et_description_request3);
        tv_currency_request3 = (TextView)findViewById(R.id.tv_currency_request3);
        et_amount_request3 = (EditText)findViewById(R.id.et_amount_request3);
        tv_upload_request3 = (TextView)findViewById(R.id.tv_upload_request3);
        ibtn_doc_detail_request = (ImageButton)findViewById(R.id.ibtn_doc_detail_request3);
        btn_submit_request3 = (Button)findViewById(R.id.btn_submit_request3);

        btn_submit_request3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Request3Activity.this,RequestDetailActivity.class);
                startActivity(intent);
            }
        });

    }
}

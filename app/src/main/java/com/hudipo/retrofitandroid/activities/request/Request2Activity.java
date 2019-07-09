package com.hudipo.retrofitandroid.activities.request;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.hudipo.retrofitandroid.R;

public class Request2Activity extends AppCompatActivity {

    Spinner sp_doc_request2;
    TextView tv_doc_detail_request2;
    ImageButton ibtn_doc_detail_request2;
    Button btn_next_request2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request2);

        sp_doc_request2 = (Spinner)findViewById(R.id.sp_doc_request2);
        tv_doc_detail_request2 = (TextView)findViewById(R.id.tv_doc_detail_request2);
        ibtn_doc_detail_request2 = (ImageButton)findViewById(R.id.ibtn_doc_detail_request2);
        btn_next_request2 = (Button)findViewById(R.id.btn_next_request2);

        btn_next_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Request2Activity.this,Request3Activity.class);
                startActivity(intent);
            }
        });


    }
}

package com.hudipo.pum_indomaret.activities.request;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.hudipo.pum_indomaret.R;

import java.util.concurrent.TimeUnit;

public class Request2Activity extends AppCompatActivity {

//    String myLog = "myLog";
//    AlphaAnimation inAnimation;
//    AlphaAnimation outAnimation;
//    FrameLayout progressBarHolder;

    Spinner sp_doc_request2;
    TextView tv_doc_detail_request2;
    ImageButton ibtn_doc_detail_request2;
    Button btn_next_request2;

    String str_emp_name;
    String str_sp_emp_dep;
    String strtgl;
    String strtgl2;
    String str_sp_doc_request2;
    String str_tv_doc_detail_request2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request2);
//
//        Intent intent = getIntent();
//        str_emp_name = intent.getStringExtra("kirimname");
//        str_sp_emp_dep = intent.getStringExtra("kiridept");
//        strtgl = intent.getStringExtra("kirimtanggal");
//        strtgl2 = intent.getStringExtra("kirimtanggal2");


        sp_doc_request2 = (Spinner)findViewById(R.id.sp_doc_request2);
        tv_doc_detail_request2 = (TextView)findViewById(R.id.tv_doc_detail_request2);
        ibtn_doc_detail_request2 = (ImageButton)findViewById(R.id.ibtn_doc_detail_request2);
        btn_next_request2 = (Button)findViewById(R.id.btn_next_request2);

        ibtn_doc_detail_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);
                Intent intent = new Intent(Request2Activity.this,RequestDocument.class);
//                new MyTask().execute();
                startActivity(intent);
            }
        });





        btn_next_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                str_sp_doc_request2 ="HRD";
//                str_tv_doc_detail_request2= tv_doc_detail_request2.getText().toString() ;

                Intent intent = new Intent(Request2Activity.this, Request3Activity.class);
//                intent.putExtra("kirimnama",str_emp_name);
//                intent.putExtra("kiridept",str_sp_emp_dep);
//                intent.putExtra("kirimtanggal1",strtgl);
//                intent.putExtra("kirimtanggal2",strtgl2);
//                intent.putExtra("kirimdoc",str_sp_doc_request2);
//                intent.putExtra("kirimdocdetail",str_tv_doc_detail_request2);

                startActivity(intent);

            }
        });


    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.button:
//                new MyTask().execute();
//                break;
//        }
//
//    }

//    private class MyTask extends AsyncTask<Void, Void, Void> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            ibtn_doc_detail_request2.setEnabled(false);
//            inAnimation = new AlphaAnimation(0f, 1f);
//            inAnimation.setDuration(200);
//            progressBarHolder.setAnimation(inAnimation);
//            progressBarHolder.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            outAnimation = new AlphaAnimation(1f, 0f);
//            outAnimation.setDuration(200);
//            progressBarHolder.setAnimation(outAnimation);
//            progressBarHolder.setVisibility(View.GONE);
//            ibtn_doc_detail_request2.setEnabled(true);
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            try {
//                for (int i = 0; i < 5; i++) {
//                    Log.d(myLog, "Emulating some task.. Step " + i);
//                    TimeUnit.SECONDS.sleep(1);
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
}

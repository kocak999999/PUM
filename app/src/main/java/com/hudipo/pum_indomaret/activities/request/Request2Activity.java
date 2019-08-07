package com.hudipo.pum_indomaret.activities.request;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.hudipo.pum_indomaret.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Request2Activity extends AppCompatActivity {



    Spinner sp_doc_request2;
    TextView tv_doc_detail_request2;
    ImageButton ibtn_doc_detail_request2;
    Button btn_next_request2;
    String strDocSelected;
    List<String> list;
    Spinner spinnerColorChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request2);


        sp_doc_request2 = (Spinner) findViewById(R.id.sp_doc_request2);
        tv_doc_detail_request2 = (TextView) findViewById(R.id.tv_doc_detail_request2);
        ibtn_doc_detail_request2 = (ImageButton) findViewById(R.id.ibtn_doc_detail_request2);
        btn_next_request2 = (Button) findViewById(R.id.btn_next_request2);

        ibtn_doc_detail_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: bikin validasi kalau doc type yg kepilih "-" tombol ga bisa diteken
//                if (list.contains("-")) {
//                    ibtn_doc_detail_request2.setEnabled(false);
//                } else {
//                    Intent intent = new Intent(Request2Activity.this, RequestDocument.class);
//                    startActivity(intent);
//                }

                Intent intent = new Intent(Request2Activity.this, RequestDocument.class);
                startActivity(intent);

            }
        });


        btn_next_request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Request2Activity.this, Request3Activity.class);
                startActivity(intent);

            }
        });

        getDocSpinner();

    }



    public void getDocSpinner() {

        list = new ArrayList<String>();
        list.add("-");
        list.add("Purchase Order (PO)");
        list.add("Surat Pesanan (SP)");
        list.add("Permintaan Pembelian (PP)");

        spinnerColorChange = (Spinner) findViewById(R.id.sp_doc_request2);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.custom_textview_to_spinner, list);
        dataAdapter.setDropDownViewResource(R.layout.custom_textview_to_spinner);
        spinnerColorChange.setAdapter(dataAdapter);

//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list){
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent){
//                // Get the Item from ListView
//                View view = super.getView(position, convertView, parent);
//
//                // Initialize a TextView for ListView each Item
//                TextView tv = (TextView) view.findViewById(android.R.id.text1);
//
//                // Set the text color of TextView (ListView Item)
//                tv.setTextColor(Color.RED);
//
//                // Generate ListView Item using TextView
//                return view;
//            }
//        };

        sp_doc_request2.setAdapter(dataAdapter);
        sp_doc_request2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strDocSelected = list.get(position);
                if(strDocSelected.equals("-")){
                    ibtn_doc_detail_request2.setEnabled(false);
                    //TODO: cari cara nya
                    ibtn_doc_detail_request2.setBackgroundResource(R.drawable.bginput4);
                }else{
                    ibtn_doc_detail_request2.setEnabled(true);
                    ibtn_doc_detail_request2.setBackgroundResource(R.drawable.bginput3);
                }

//                Toast.makeText(Request2Activity.this, strDocSelected2, Toast.LENGTH_SHORT).show();
                int lengthOfSpinner = strDocSelected.length();

                if (lengthOfSpinner > 3) {
                    Toast.makeText(Request2Activity.this, String.valueOf(lengthOfSpinner), Toast.LENGTH_SHORT).show();
                    lengthOfSpinner = lengthOfSpinner - 3;
                    String strDocSelected2 = strDocSelected.substring(lengthOfSpinner, lengthOfSpinner + 2);
                    Toast.makeText(Request2Activity.this, strDocSelected2, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

}

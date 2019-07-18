package com.hudipo.pum_indomaret.activities.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.hudipo.pum_indomaret.R;
import com.hudipo.pum_indomaret.activities.LoginActivity;
import com.hudipo.pum_indomaret.storage.SharedPrefManager;

public class SettingActivity extends AppCompatActivity {

    CardView cdv_change_pp;
    CardView cdv_change_pin;
    CardView cdv_logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        cdv_change_pp = (CardView) findViewById(R.id.cdv_change_pp);
        cdv_change_pin = (CardView) findViewById(R.id.cdv_change_pin);
        cdv_logout = (CardView) findViewById(R.id.cdv_logout);

        cdv_change_pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ChangePhotoActivity.class);
                startActivity(intent);

            }
        });

        cdv_change_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ChangePinActivity.class);
                startActivity(intent);
            }
        });


        cdv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        SharedPrefManager.getInstance(this).clear();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}

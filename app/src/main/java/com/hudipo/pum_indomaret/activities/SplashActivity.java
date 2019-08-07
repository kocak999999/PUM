package com.hudipo.pum_indomaret.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hudipo.pum_indomaret.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=2000;
    ImageView login_bg;
    ImageView logo_pum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo_pum = (ImageView)findViewById(R.id.logoPum);
        Glide.with(this).load(R.drawable.logo).into(logo_pum);

        login_bg = (ImageView) findViewById(R.id.login_bg);
        login_bg.animate().scaleX(2).scaleY(2).setDuration(7000).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(homeIntent);

            }
        },SPLASH_TIME_OUT);
    }
}

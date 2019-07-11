package com.hudipo.pum_indomaret.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.hudipo.pum_indomaret.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=3000;
    ImageView login_bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        login_bg = (ImageView) findViewById(R.id.login_bg);
        login_bg.animate().scaleX(2).scaleY(2).setDuration(8000).start();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashActivity.this, RegisterActivity.class);
                startActivity(homeIntent);

            }
        },SPLASH_TIME_OUT);
    }
}

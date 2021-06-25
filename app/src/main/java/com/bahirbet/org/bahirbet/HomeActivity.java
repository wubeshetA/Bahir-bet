package com.bahirbet.org.bahirbet;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);

    }

    public void openfootBall(View view) {
        Intent intent = new Intent(HomeActivity.this, FootBallHomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferencesConfig sharedPreferencesConfig = new SharedPreferencesConfig(getApplicationContext());
        sharedPreferencesConfig.writeMatch_1_Odd("1x");
        sharedPreferencesConfig.writeMatch_2_Odd("1x");
        sharedPreferencesConfig.writeMatch_3_Odd("1x");
        sharedPreferencesConfig.writeMatch_4_Odd("1x");

    }
}

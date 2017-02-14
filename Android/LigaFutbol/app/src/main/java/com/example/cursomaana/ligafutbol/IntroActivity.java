package com.example.cursomaana.ligafutbol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Intent nextIntent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(nextIntent);
    }
}

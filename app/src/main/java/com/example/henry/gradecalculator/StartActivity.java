package com.example.henry.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void gradeBtnClick(View view) {

    }

    public void gpaBtnClick(View view) {
        Intent intent = new Intent(this, GPA_Calc.class);
        startActivity(intent);
    }
}

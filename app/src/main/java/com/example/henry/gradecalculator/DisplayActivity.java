package com.example.henry.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        double result;
        String caller = intent.getStringExtra("caller");
        TextView display = (TextView)findViewById(R.id.display);
        TextView res = (TextView)findViewById(R.id.result);

        if(caller.equals("GPA")) {
            result = intent.getDoubleExtra("gpa", 0.0);
            display.setText("Your GPA is: ");
            res.setText(result + "");
        }
        else if(caller.equals("grade")) {
            result = intent.getDoubleExtra("percentNeeded", 0.0);
            display.setText("Needed Percentage: ");
            res.setText(result + "");
        }
    }

    public void returnHomeBtn(View view) {
        finish();
    }
}

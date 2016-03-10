package com.example.henry.gradecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class GPA_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa__calc);
    }


    //changes letter grade to point equivalent
    public double gradeToPoints(String grade) {
        char gr[] = grade.trim().toUpperCase().toCharArray();
        Log.d("test", "trim");
        double points = 0;
        if(gr[0] == 'A') {
            if(gr.length > 1 && gr[1] == '-')
                points = 3.67;
            else
                points = 4.0;
        }
        else if(gr[0] == 'B') {
            if(gr.length > 1 && gr[1] == '+')
                points = 3.33;
            else if(gr.length > 1 && gr[1] == '-')
                points = 3.00;
            else
                points = 2.67;
        }
        else if(gr[0] == 'C') {
            if(gr.length > 1 && gr[1] == '+')
                points = 2.33;
            else if(gr.length > 1 && gr[1] == '-')
                points = 2.00;
            else
                points = 1.67;
        }
        else if(gr[0] == 'D') {
            if(gr.length > 1 && gr[1] == '+')
                points = 1.33;
            else if(gr.length > 1 && gr[1] == '-')
                points = 1.00;
            else
                points = 0.67;
        }
        else if(gr[0] == 'F') {
            points = 0;
        }
        return points;
    }

    public void finishedBtn(View view) {
        EditText gradeEdit = null;
        EditText unitEdit = null;

        int creditHours = 0;

        String gr, ut;
        int units;
        int totUnits = 0;
        double totPts = 0, pts;

        for(int i = 0; i < 6; i++) {
            //get correct edit text fields
            if (i == 0) {
                gradeEdit = (EditText) findViewById(R.id.grade1);
                unitEdit = (EditText) findViewById(R.id.unit1);
            } else if (i == 1) {
                gradeEdit = (EditText) findViewById(R.id.grade2);
                unitEdit = (EditText) findViewById(R.id.unit2);
            } else if (i == 2) {
                gradeEdit = (EditText) findViewById(R.id.grade3);
                unitEdit = (EditText) findViewById(R.id.unit3);
            } else if (i == 3) {
                gradeEdit = (EditText) findViewById(R.id.grade4);
                unitEdit = (EditText) findViewById(R.id.unit4);
            } else if (i == 4) {
                gradeEdit = (EditText) findViewById(R.id.grade5);
                unitEdit = (EditText) findViewById(R.id.unit5);
            } else if (i == 5) {
                gradeEdit = (EditText) findViewById(R.id.grade5);
                unitEdit = (EditText) findViewById(R.id.unit5);
            }

            //empty fields
            gr = gradeEdit.getText().toString();
            ut = unitEdit.getText().toString();

            if (gr.equals("") || ut.equals("")
                    || unitEdit.getText() == null || gradeEdit.getText() == null) {
                continue;
            }

            //get the text values
            pts = gradeToPoints(gr);
            try {
                units = Integer.parseInt(ut);
            } catch (NumberFormatException e) {
                continue;
            }

            //calculate total
            totPts = (pts * units) + totPts;
            totUnits += units;
        }
        double gpa = totPts/totUnits;
        gpa = Math.round(gpa*100.0)/100.0; //round to 2 decimal places

        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("gpa", gpa);
        intent.putExtra("caller", "GPA");
        startActivity(intent);

        finish();
    }
}

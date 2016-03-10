package com.example.henry.gradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText gradeEdit = (EditText)findViewById(R.id.grade1);
        EditText unitEdit = (EditText)findViewById(R.id.unit1);

        int creditHours = 0;

        String gr;
        int units;
        int totUnits = 0;
        double totPts = 0, pts;

        for(int i = 0; i < 6; i++) {
            //empty fields
            if (gradeEdit.getText().toString().equals("")
                    || unitEdit.getText().toString().equals(""))
                continue;

            //get the text values
            gr = gradeEdit.getText().toString();
            units = Integer.getInteger(unitEdit.getText().toString()).intValue();
            pts = gradeToPoints(gr);

            //calculate total
            totPts = (pts*units) + totPts;
            totUnits += units;
        }

        double gpa = totPts/totUnits;



    }
}

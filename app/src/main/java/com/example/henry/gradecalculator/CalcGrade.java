package com.example.henry.gradecalculator;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class CalcGrade extends AppCompatActivity {
    int currLinearLayout = R.id.input1;
    ArrayList<Integer> points = new ArrayList<>();
    ArrayList<Integer> weights = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_grade);
    }

    public void addAField(View view) {
        RelativeLayout myLayout = (RelativeLayout)findViewById(R.id.myLayout);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        //create new input field
        EditText field1 = new EditText(this);
        field1.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1.0f
        ));

        EditText field2 = new EditText(this);
        field2.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1.0f
        ));

        //adds to linear layout
        field1.setHint("Percent in category");
        field2.setHint("Percent of category");
        linearLayout.addView(field1);
        linearLayout.addView(field2);

        //keep track of ids
        int point = View.generateViewId();
        int weight = View.generateViewId();
        points.add(point);
        weights.add(weight);

        //set ids
        linearLayout.setId(currLinearLayout + 1);
        field1.setId(point);
        field2.setId(weight);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        params.addRule(RelativeLayout.BELOW, currLinearLayout);
        myLayout.addView(linearLayout, params);
        currLinearLayout++;
    }


    public void doneFill(View view) {
        EditText desiredEditText = (EditText) findViewById(R.id.desiredPercentage);
        String desiredStr = desiredEditText.getText().toString();
        double desiredPercent;
        //find users desired percentage
        try {
            desiredPercent = Integer.parseInt(desiredStr);
        } catch (NumberFormatException e) {
            desiredPercent = 0;
        }

        points.add(R.id.points1);
        weights.add(R.id.weight1);

        EditText pointsField;
        EditText weightsField;

        double point, weight, currTotal = 0;
        double percents = 0;

        //calculate how much percent is still needed
        for(int index = 0; index < points.size(); index++) {
            pointsField = (EditText) findViewById(points.get(index));
            weightsField = (EditText) findViewById(weights.get(index));
            try {
                point = Integer.parseInt(pointsField.getText().toString());
                weight = Integer.parseInt(weightsField.getText().toString());
            } catch (NumberFormatException e) {
                point = 0;
                weight = 0;
            }

            currTotal = point * weight + currTotal;
            percents += weight;
        }
        currTotal = currTotal / 100;
        percents = 100 - percents; // remaining percentage needed
        double percentNeeded = desiredPercent - currTotal;
        percentNeeded = percentNeeded/percents;

        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("caller", "grade");
        intent.putExtra("percentNeeded", percentNeeded);
        startActivity(intent);
    }
}

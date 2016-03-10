package com.example.henry.gradecalculator;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class CalcGrade extends AppCompatActivity {
    int currLinearLayout = R.id.input1;

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
        field1.setHint("Points in category");
        field2.setHint("Category weight");
        linearLayout.addView(field1);
        linearLayout.addView(field2);

        //set id
        linearLayout.setId(currLinearLayout+1);


        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        params.addRule(RelativeLayout.BELOW, currLinearLayout);
        myLayout.addView(linearLayout, params);
        currLinearLayout++;
    }


    public void doneFill(View view) {
    }
}

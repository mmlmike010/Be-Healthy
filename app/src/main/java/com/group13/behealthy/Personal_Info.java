package com.group13.behealthy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Personal_Info extends AppCompatActivity {
    EditText age, feet, inches, gender, weight;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);
        age = (EditText)findViewById(R.id.AgeInput);
        feet = (EditText)findViewById(R.id.HeightFeet);
        inches = (EditText)findViewById(R.id.HeightInches);
        weight = (EditText)findViewById(R.id.WeightInput);
        gender = (EditText)findViewById(R.id.GenderInput);
    };
    public void PInext(View v) {
        if (v.getId() == R.id.BPInext) {
            Intent j = new Intent(Personal_Info.this, Progress_Dashboard.class);
            startActivity(j);
        }
    }

    public double calculateCalories(int age, int feet, int inches, int weight, String gender){
        double totalheight = 2.54*(feet*12 + inches);
        double BMR = 10*0.453592*weight + 6.25*totalheight - 5*age;
        if(gender.equals("male")){
            BMR = BMR + 5;
        }
        else if(gender.equals("female")) {
            BMR = BMR - 161;
        }
        return BMR;
    }
}


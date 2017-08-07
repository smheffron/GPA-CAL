package com.shelby.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent myintent = getIntent();

        String gpa = myintent.getStringExtra("GPAString");
        String hours = myintent.getStringExtra("HourString");
        String number = myintent.getStringExtra("numberString");


        double GPA = Double.parseDouble(gpa);
        int hour = Integer.parseInt(hours);
        int num = Integer.parseInt(number);

        gradeData grades = new gradeData(GPA, hour, num);

        grades.fillCourseArray();

        double garb;

        garb = grades.calculateGPA();







        Button btn2;

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

    }
}

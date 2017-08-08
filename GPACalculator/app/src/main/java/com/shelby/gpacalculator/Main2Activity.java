package com.shelby.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        String gpa = "NULL";
        String hours = "NULL";
        String number = "NULL";

        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();

        if(bundle != null)
        {
            gpa = bundle.getString("GPAString");
            hours = bundle.getString("HoursString");
            number = bundle.getString("NumberString");
        }

        //Retrieved from MainActivity.java
        final double realGPA = Double.parseDouble(gpa);
        final int realHours = Integer.parseInt(hours);
        final int realNumberofClasses = Integer.parseInt(number);
        //Retrieved from Main2Activity.java





        Button btn2;

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);

                EditText hourOne;
                hourOne = (EditText)findViewById(R.id.hour1);

                EditText gradeOne;
                gradeOne = (EditText)findViewById(R.id.grade1);

                int hourONE = Integer.parseInt(hourOne.getText().toString());
                int gradeONE = Integer.parseInt(gradeOne.getText().toString());

                gradeData grades = new gradeData(realGPA, realHours, realNumberofClasses);
                grades.fillCourseArray(hourONE, gradeONE, 0);
                double result = grades.calculateGPA();
                String Result = Double.toString(result);

                intent.putExtra("RESULT",Result);


                startActivity(intent);
            }
        });

    }
}

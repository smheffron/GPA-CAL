package com.shelby.gpacalculator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String gpa = "NULL";
        String hours = "NULL";
        String number = "NULL";

        //Receive 3 Strings of data from activiy 1
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

        Button btn2;

        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);

                //Get data from all EditText fields
                EditText hourOne;
                hourOne = (EditText)findViewById(R.id.hour1);

                EditText gradeOne;
                gradeOne = (EditText)findViewById(R.id.grade1);

                EditText hourTwo;
                hourTwo = (EditText)findViewById(R.id.hour2);

                EditText gradeTwo;
                gradeTwo = (EditText)findViewById(R.id.grade2);

                EditText hourThree;
                hourThree = (EditText)findViewById(R.id.hour3);

                EditText gradeThree;
                gradeThree = (EditText)findViewById(R.id.grade3);

                EditText hourFour;
                hourFour = (EditText)findViewById(R.id.hour4);

                EditText gradeFour;
                gradeFour = (EditText)findViewById(R.id.grade4);

                EditText hourFive;
                hourFive = (EditText)findViewById(R.id.hour5);

                EditText gradeFive;
                gradeFive = (EditText)findViewById(R.id.grade5);

                EditText hourSix;
                hourSix = (EditText)findViewById(R.id.hour6);

                EditText gradeSix;
                gradeSix = (EditText)findViewById(R.id.grade6);


                //Turn EditText data into Strings in order to check ifEmpty()
                String HOURONE = hourOne.getText().toString();
                String GRADEONE = gradeOne.getText().toString();

                String HOURTWO = hourTwo.getText().toString();
                String GRADETWO = gradeTwo.getText().toString();

                String HOURTHREE = hourThree.getText().toString();
                String GRADETHREE = gradeThree.getText().toString();

                String HOURFOUR = hourFour.getText().toString();
                String GRADEFOUR = gradeFour.getText().toString();

                String HOURFIVE = hourFive.getText().toString();
                String GRADEFIVE = gradeFive.getText().toString();

                String HOURSIX = hourSix.getText().toString();
                String GRADESIX = gradeSix.getText().toString();


                //make sure at least one field is filled out, display toast error if not
                if(HOURSIX.isEmpty()==true && GRADESIX.isEmpty()==true && HOURFIVE.isEmpty()==true && GRADEFIVE.isEmpty()==true && HOURFOUR.isEmpty()==true && GRADEFOUR.isEmpty()==true && HOURTHREE.isEmpty()==true && GRADETHREE.isEmpty()==true && HOURTWO.isEmpty()==true && GRADETWO.isEmpty()==true && HOURONE.isEmpty()==true && GRADEONE.isEmpty()==true)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Entry Required";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {

                    //initialize all fields to 0 for error handling (in case that some are left blank)

                    int hourONE = 0;
                    double gradeONE = 0;

                    int hourTWO = 0;
                    double gradeTWO = 0;

                    int hourTHREE = 0;
                    double gradeTHREE = 0;

                    int hourFOUR = 0;
                    double gradeFOUR = 0;

                    int hourFIVE = 0;
                    double gradeFIVE = 0;

                    int hourSIX = 0;
                    double gradeSIX = 0;

                    //check to make sure EditText fields were not empty before getting their data
                    if(HOURONE.isEmpty() != true) {
                        hourONE = Integer.parseInt(hourOne.getText().toString());
                    }
                    if(GRADEONE.isEmpty()!=true) {
                        gradeONE = Double.parseDouble(gradeOne.getText().toString());
                    }
                    if(HOURTWO.isEmpty()!=true) {
                        hourTWO = Integer.parseInt(hourTwo.getText().toString());
                    }
                    if (GRADETWO.isEmpty()!=true)
                    {
                        gradeTWO = Double.parseDouble(gradeTwo.getText().toString());
                    }

                    if(HOURTHREE.isEmpty()!=true){
                        hourTHREE = Integer.parseInt(hourThree.getText().toString());
                    }
                    if(GRADETHREE.isEmpty()!=true){
                        gradeTHREE = Double.parseDouble(gradeThree.getText().toString());
                    }

                    if(HOURFOUR.isEmpty()!=true){
                        hourFOUR = Integer.parseInt(hourFour.getText().toString());
                    }
                    if(GRADEFOUR.isEmpty()!=true){
                        gradeFOUR = Double.parseDouble(gradeFour.getText().toString());
                    }

                    if(HOURFIVE.isEmpty()!=true)
                    {
                        hourFIVE = Integer.parseInt(hourFive.getText().toString());
                    }
                    if(GRADEFIVE.isEmpty()!=true){
                        gradeFIVE = Double.parseDouble(gradeFive.getText().toString());
                    }

                    if(HOURSIX.isEmpty()!=true){
                        hourSIX = Integer.parseInt(hourSix.getText().toString());
                    }
                    if(GRADESIX.isEmpty()!=true){
                        gradeSIX = Double.parseDouble(gradeSix.getText().toString());
                    }

                    //Actual GPA Calculations
                    gradeData grades = new gradeData(realGPA, realHours, realNumberofClasses);
                    grades.fillCourseArray(hourONE, gradeONE, 0);
                    grades.fillCourseArray(hourTWO, gradeTWO, 1);
                    grades.fillCourseArray(hourTHREE, gradeTHREE, 2);
                    grades.fillCourseArray(hourFOUR, gradeFOUR, 3);
                    grades.fillCourseArray(hourFIVE, gradeFIVE, 4);
                    grades.fillCourseArray(hourSIX, gradeSIX, 5);
                    double result = grades.calculateGPA();

                    double roundOff = (double) Math.round(result * 1000.000) / 1000.000;

                    String Result = Double.toString(roundOff);

                    //Send result to next activity for viewing
                    intent.putExtra("RESULT", Result);
                    startActivity(intent);
                }
            }
        });

    }
}

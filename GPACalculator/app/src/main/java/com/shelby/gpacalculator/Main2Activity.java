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


                if(HOURSIX.isEmpty()==true && GRADESIX.isEmpty()==true && HOURFIVE.isEmpty()==true && GRADEFIVE.isEmpty()==true && HOURFOUR.isEmpty()==true && GRADEFOUR.isEmpty()==true && HOURTHREE.isEmpty()==true && GRADETHREE.isEmpty()==true && HOURTWO.isEmpty()==true && GRADETWO.isEmpty()==true && HOURONE.isEmpty()==true && GRADEONE.isEmpty()==true)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Entry Required";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {

                    int hourONE = 0;
                    int gradeONE = 0;

                    int hourTWO = 0;
                    int gradeTWO = 0;

                    int hourTHREE = 0;
                    int gradeTHREE = 0;

                    int hourFOUR = 0;
                    int gradeFOUR = 0;

                    int hourFIVE = 0;
                    int gradeFIVE = 0;

                    int hourSIX = 0;
                    int gradeSIX = 0;

                    if(HOURONE.isEmpty() != true) {
                        hourONE = Integer.parseInt(hourOne.getText().toString());
                    }
                    if(GRADEONE.isEmpty()!=true) {
                        gradeONE = Integer.parseInt(gradeOne.getText().toString());
                    }
                    if(HOURTWO.isEmpty()!=true) {
                        hourTWO = Integer.parseInt(hourTwo.getText().toString());
                    }
                    if (GRADETWO.isEmpty()!=true)
                    {
                        gradeTWO = Integer.parseInt(gradeTwo.getText().toString());
                    }

                    if(HOURTHREE.isEmpty()!=true){
                        hourTHREE = Integer.parseInt(hourThree.getText().toString());
                    }
                    if(GRADETHREE.isEmpty()!=true){
                        gradeTHREE = Integer.parseInt(gradeThree.getText().toString());
                    }


                    if(HOURFOUR.isEmpty()!=true){
                        hourFOUR = Integer.parseInt(hourFour.getText().toString());
                    }
                    if(GRADEFOUR.isEmpty()!=true){
                        gradeFOUR = Integer.parseInt(gradeFour.getText().toString());
                    }

                    if(HOURFIVE.isEmpty()!=true)
                    {
                        hourFIVE = Integer.parseInt(hourFive.getText().toString());
                    }
                    if(GRADEFIVE.isEmpty()!=true){
                        gradeFIVE = Integer.parseInt(gradeFive.getText().toString());
                    }

                    if(HOURSIX.isEmpty()!=true){
                        hourSIX = Integer.parseInt(hourSix.getText().toString());
                    }
                    if(!GRADESIX.isEmpty()){
                        gradeSIX = Integer.parseInt(gradeSix.getText().toString());
                    }

                    gradeData grades = new gradeData(realGPA, realHours, realNumberofClasses);
                    grades.fillCourseArray(hourONE, gradeONE, 0);
                    grades.fillCourseArray(hourTWO, gradeTWO, 1);
                    grades.fillCourseArray(hourTHREE, gradeTHREE, 2);
                    grades.fillCourseArray(hourFOUR, gradeFOUR, 3);
                    grades.fillCourseArray(hourFIVE, gradeFIVE, 4);
                    grades.fillCourseArray(hourSIX, gradeSIX, 5);
                    double result = grades.calculateGPA();
                    String Result = Double.toString(result);

                    intent.putExtra("RESULT", Result);
                    startActivity(intent);
                }
            }
        });

    }
}

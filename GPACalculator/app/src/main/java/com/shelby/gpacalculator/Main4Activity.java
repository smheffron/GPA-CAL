package com.shelby.gpacalculator;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.WindowManager;



public class Main4Activity extends AppCompatActivity {

    final Context context = this;
    //EditTexts from dioglogue box
    EditText gradeDio;
    EditText hoursDio;
    //add class button from diologue box
    Button btn2;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //Recieve data from activity 1
        String gpa = "NULL";
        String hours = "NULL";

        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();

        if(bundle != null)
        {
            gpa = bundle.getString("GPAString");
            hours = bundle.getString("HoursString");
        }

        //Retrieved from MainActivity.java
        final double realGPA = Double.parseDouble(gpa);
        final int realHours = Integer.parseInt(hours);

        //add a class button
        Button button = (Button) findViewById(R.id.addClass);

        //create TextViews to display each classes credit hours and grade percentage
        final TextView hourOne;
        hourOne= (TextView)findViewById(R.id.hour1);
        final TextView gradeOne;
        gradeOne = (TextView)findViewById(R.id.grade1);

        final TextView hourTwo;
        hourTwo = (TextView)findViewById(R.id.hour2);
        final TextView gradeTwo;
        gradeTwo = (TextView)findViewById(R.id.grade2);

        final TextView hourThree;
        hourThree = (TextView)findViewById(R.id.hour3);
        final TextView gradeThree;
        gradeThree = (TextView)findViewById(R.id.grade3);

        final TextView hourFour;
        hourFour = (TextView)findViewById(R.id.hour4);
        final TextView gradeFour;
        gradeFour = (TextView)findViewById(R.id.grade4);

        final TextView hourFive;
        hourFive = (TextView)findViewById(R.id.hour5);
        final TextView gradeFive;
        gradeFive = (TextView)findViewById(R.id.grade5);

        final TextView hourSix;
        hourSix = (TextView)findViewById(R.id.hour6);
        final TextView gradeSix;
        gradeSix = (TextView)findViewById(R.id.grade6);

        final TextView gradeSeven;
        gradeSeven = (TextView) findViewById(R.id.grade7);
        final TextView hourSeven;
        hourSeven = (TextView) findViewById(R.id.hour7);

        final TextView gradeEight;
        gradeEight = (TextView) findViewById(R.id.grade8);
        final TextView hourEight;
        hourEight = (TextView) findViewById(R.id.hour8);


        //Init temp arrays to hold data recieved from diologue box
        final String[] gradeTemp = new String[8];
        final String[] hourTemp = new String[8];
        gradeTemp[0]="0";
        gradeTemp[1]="0";
        gradeTemp[2]="0";
        gradeTemp[3]="0";
        gradeTemp[4]="0";
        gradeTemp[5]="0";
        gradeTemp[6]="0";
        gradeTemp[7]="0";

        hourTemp[0]="0";
        hourTemp[1]="0";
        hourTemp[2]="0";
        hourTemp[3]="0";
        hourTemp[4]="0";
        hourTemp[5]="0";
        hourTemp[6]="0";
        hourTemp[7]="0";

        //Hide each class until it is init by the user from the diologue box
        final LinearLayout box1 = (LinearLayout) findViewById(R.id.box1);
        box1.setVisibility(View.INVISIBLE);
        final LinearLayout box2 = (LinearLayout) findViewById(R.id.box2);
        box2.setVisibility(View.INVISIBLE);
        final LinearLayout box3 = (LinearLayout) findViewById(R.id.box3);
        box3.setVisibility(View.INVISIBLE);
        final LinearLayout box4 = (LinearLayout) findViewById(R.id.box4);
        box4.setVisibility(View.INVISIBLE);
        final LinearLayout box5 = (LinearLayout) findViewById(R.id.box5);
        box5.setVisibility(View.INVISIBLE);
        final LinearLayout box6 = (LinearLayout) findViewById(R.id.box6);
        box6.setVisibility(View.INVISIBLE);
        final LinearLayout box7 = (LinearLayout) findViewById(R.id.box7);
        box7.setVisibility(View.INVISIBLE);
        final LinearLayout box8 = (LinearLayout) findViewById(R.id.box8);
        box8.setVisibility(View.INVISIBLE);

        //counter
        final int[] i = {0};

        // add class button listener
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                //only allow 8 classes to be entered
                if(i[0]>7)
                {
                    Context context2 = getApplicationContext();
                    CharSequence text2 = "Maximum Classes Entered";
                    int duration2 = Toast.LENGTH_SHORT;
                    Toast toast2 = Toast.makeText(context2, text2, duration2);
                    toast2.show();
                }

                else
                {
                    // custom dialog launched when add class button is clicked
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.alertbox);
                    dialog.setTitle("Enter Class Information");

                    //diologue button to accept values entered in diologue
                    Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);

                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            gradeDio = (EditText) dialog.findViewById(R.id.gradeAlert);
                            hoursDio = (EditText) dialog.findViewById(R.id.creditHoursAlert);
                            String gradeCheck = gradeDio.getText().toString();

                            //check for input in the diologue box, error toast if not
                            if (gradeDio.getText().toString().isEmpty() || hoursDio.getText().toString().isEmpty()) {
                                Context context = getApplicationContext();
                                CharSequence text = "Entry Required";
                                int duration = Toast.LENGTH_SHORT;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                            else if(Double.parseDouble(gradeCheck)>100)
                            {
                                //check for valid grade value
                                Context context1 = getApplicationContext();
                                CharSequence text1 = "Max grade is 100";
                                int duration1 = Toast.LENGTH_SHORT;
                                Toast toast1 = Toast.makeText(context1, text1, duration1);
                                toast1.show();
                            }
                            else
                            {
                                //make each class visable as class is added
                                gradeTemp[i[0]] = gradeDio.getText().toString();
                                hourTemp[i[0]] = hoursDio.getText().toString();

                                if (i[0] == 0) {
                                    gradeOne.setText(gradeTemp[0]);
                                    hourOne.setText(hourTemp[0]);
                                    box1.setVisibility(View.VISIBLE);

                                }
                                if (i[0] == 1) {
                                    gradeTwo.setText(gradeTemp[1]);
                                    hourTwo.setText(hourTemp[1]);
                                    box2.setVisibility(View.VISIBLE);
                                }
                                if (i[0] == 2) {
                                    gradeThree.setText(gradeTemp[2]);
                                    hourThree.setText(hourTemp[2]);
                                    box3.setVisibility(View.VISIBLE);
                                }
                                if (i[0] == 3) {
                                    gradeFour.setText(gradeTemp[3]);
                                    hourFour.setText(hourTemp[3]);
                                    box4.setVisibility(View.VISIBLE);
                                }
                                if (i[0] == 4) {
                                    gradeFive.setText(gradeTemp[4]);
                                    hourFive.setText(hourTemp[4]);
                                    box5.setVisibility(View.VISIBLE);
                                }
                                if (i[0] == 5) {
                                    gradeSix.setText(gradeTemp[5]);
                                    hourSix.setText(hourTemp[5]);
                                    box6.setVisibility(View.VISIBLE);
                                }
                                if (i[0] == 6) {
                                    gradeSeven.setText(gradeTemp[6]);
                                    hourSeven.setText(gradeTemp[6]);
                                    box7.setVisibility(View.VISIBLE);
                                }
                                if (i[0] == 7) {
                                    gradeEight.setText(gradeTemp[7]);
                                    hourEight.setText(gradeTemp[7]);
                                    box8.setVisibility(View.VISIBLE);
                                }

                                i[0]++;
                                dialog.dismiss();
                            }
                        }
                    });

                    dialog.show();

                }

            }   });

        //next botton to activity 3
        btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this, Main3Activity.class);

                //get grade and hour data from temp arrays
                int hourONE = Integer.parseInt(hourTemp[0]);
                double gradeONE = Double.parseDouble(gradeTemp[0]);

                int hourTWO = Integer.parseInt(hourTemp[1]);
                double gradeTWO = Double.parseDouble(gradeTemp[1]);

                int hourTHREE = Integer.parseInt(hourTemp[2]);
                double gradeTHREE = Double.parseDouble(gradeTemp[2]);

                int hourFOUR = Integer.parseInt(hourTemp[3]);
                double gradeFOUR = Double.parseDouble(gradeTemp[3]);

                int hourFIVE = Integer.parseInt(hourTemp[4]);
                double gradeFIVE = Double.parseDouble(gradeTemp[4]);

                int hourSIX = Integer.parseInt(hourTemp[5]);
                double gradeSIX = Double.parseDouble(gradeTemp[5]);

                int hourSEVEN = Integer.parseInt(hourTemp[6]);
                double gradeSEVEN = Double.parseDouble(hourTemp[6]);

                int hourEIGHT = Integer.parseInt(hourTemp[7]);
                double gradeEIGHT = Double.parseDouble(hourTemp[7]);

                //Actual GPA Calculations
                gradeData grades = new gradeData(realGPA, realHours, 8);
                grades.fillCourseArray(hourONE, gradeONE, 0);
                grades.fillCourseArray(hourTWO, gradeTWO, 1);
                grades.fillCourseArray(hourTHREE, gradeTHREE, 2);
                grades.fillCourseArray(hourFOUR, gradeFOUR, 3);
                grades.fillCourseArray(hourFIVE, gradeFIVE, 4);
                grades.fillCourseArray(hourSIX, gradeSIX, 5);
                grades.fillCourseArray(hourSEVEN, gradeSEVEN, 6);
                grades.fillCourseArray(hourEIGHT, gradeEIGHT, 7);
                double result = grades.calculateGPA();

                //round gpa calculation to 3 decimals
                double roundOff = (double) Math.round(result * 1000.000) / 1000.000;
                String Result = Double.toString(roundOff);

                //Send result to next activity (3) for viewing
                intent.putExtra("RESULT", Result);
                startActivity(intent);
            }
        });
    }
}
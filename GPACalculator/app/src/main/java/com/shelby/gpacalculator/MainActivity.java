package com.shelby.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //next button
        Button btn;

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //three EditText fields for GPA, Credit Hours, number of courses this semester -- turned into strings
                EditText currentGPA;
                currentGPA = (EditText)findViewById(R.id.currentGPA);


                EditText passedHours;
                passedHours = (EditText)findViewById(R.id.passedHours);


                EditText classNumber;
                classNumber = (EditText)findViewById(R.id.classNumber);

                String GPA = currentGPA.getText().toString();

                String HOURS = passedHours.getText().toString();

                String NUMBER = classNumber.getText().toString();

                //handling user input, all 3 fields must be completed, toast error message shown if not
                if(GPA.isEmpty()==true || HOURS.isEmpty()==true || NUMBER.isEmpty()==true)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Entry Required";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if((Integer.parseInt(NUMBER)>6))
                {
                    Context context2 = getApplicationContext();
                    CharSequence text2 = "Maximum of 6 classes";
                    int duration2 = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context2, text2, duration2);
                    toast.show();
                }
                else
                {
                    //move to next activity and bring the data in all 3 fields
                    Intent intent = new Intent(getBaseContext(), Main4Activity.class);
                    intent.putExtra("GPAString", GPA);
                    intent.putExtra("HoursString", HOURS);
                    intent.putExtra("NumberString", NUMBER);
                    startActivity(intent);
                }
            }
        });

    }

}

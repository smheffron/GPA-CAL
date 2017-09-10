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

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //next button
        Button btn;
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Two EditText fields for GPA, Credit Hours
                EditText currentGPA;
                currentGPA = (EditText)findViewById(R.id.currentGPA);

                EditText passedHours;
                passedHours = (EditText)findViewById(R.id.passedHours);

                //Convert EditText into String in order to error check
                String GPA = currentGPA.getText().toString();
                String HOURS = passedHours.getText().toString();

                //handling user input, all fields must be completed, toast error message shown if not
                if(GPA.isEmpty()==true || HOURS.isEmpty()==true)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Entry Required";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                //If GPA is > 4 on a 4.0 scale, toast error
                else if (Double.parseDouble(GPA) > 4)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Max GPA is 4.0";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                //If data in all fields is valid, move to next activity
                else
                {
                    //move to next activity and bring the data in all fields
                    Intent intent = new Intent(getBaseContext(), Main4Activity.class);
                    intent.putExtra("GPAString", GPA);
                    intent.putExtra("HoursString", HOURS);
                    startActivity(intent);
                }
            }
        });

    }

}

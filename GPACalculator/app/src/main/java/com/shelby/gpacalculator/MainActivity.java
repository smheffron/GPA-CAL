package com.shelby.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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




        Button btn;

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText currentGPA;
                currentGPA = (EditText)findViewById(R.id.currentGPA);


                EditText passedHours;
                passedHours = (EditText)findViewById(R.id.passedHours);


                EditText classNumber;
                classNumber = (EditText)findViewById(R.id.classNumber);

                String GPA = currentGPA.getText().toString();

                String HOURS = passedHours.getText().toString();

                String NUMBER = classNumber.getText().toString();

                if(GPA.isEmpty()==true || HOURS.isEmpty()==true || NUMBER.isEmpty()==true)
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Entry Required";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else
                {
                    Intent intent = new Intent(getBaseContext(), Main2Activity.class);
                    intent.putExtra("GPAString", GPA);
                    intent.putExtra("HoursString", HOURS);
                    intent.putExtra("NumberString", NUMBER);
                    startActivity(intent);
                }
            }
        });

    }
}

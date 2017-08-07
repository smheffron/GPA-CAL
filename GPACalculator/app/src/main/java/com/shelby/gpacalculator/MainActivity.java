package com.shelby.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("GPAString", currentGPA.getText().toString());
                intent.putExtra("HoursString", passedHours.getText().toString());
                intent.putExtra("NumberString", classNumber.getText().toString());
                startActivity(intent);
            }
        });

    }
}

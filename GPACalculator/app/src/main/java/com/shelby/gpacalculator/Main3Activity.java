package com.shelby.gpacalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


      String Result = "NULL";

        //Receive GPA result from activity 2
        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();

        if(bundle != null)
        {
            Result = bundle.getString("RESULT");
        }

        //Display GPA result in a TextView
        TextView text = (TextView)findViewById(R.id.GPA_RESULT);

        text.setText("Your GPA is:\n"+Result);



    }
}

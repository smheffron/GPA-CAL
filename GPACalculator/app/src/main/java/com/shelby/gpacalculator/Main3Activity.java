package com.shelby.gpacalculator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;


public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        String Result = "NULL";

        //Receive GPA result from activity 4
        Intent intent1 = getIntent();
        Bundle bundle = intent1.getExtras();

        if(bundle != null)
        {
            Result = bundle.getString("RESULT");
        }

        String junk = "Your GPA is\n" + Result;

        //make spannable so that gpa number is larger text than "Your GPA is: "
        SpannableString ss1=  new SpannableString(junk);
        ss1.setSpan(new RelativeSizeSpan(.5f), 0,12, 0);
        ss1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 12, 0);

        //Display GPA result in a TextView
        TextView text = (TextView)findViewById(R.id.GPA_RESULT);
        text.setText(ss1);
    }
}

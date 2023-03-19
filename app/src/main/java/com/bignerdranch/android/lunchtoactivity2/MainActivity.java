package com.bignerdranch.android.lunchtoactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextContent;
    private Button mButtonLaunchSecondActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //when the user click the button,
        // we want to launch the second activity and pas the data

        //bind the variables with the widget
        mEditTextContent=(EditText) findViewById(R.id.textContent);
        mButtonLaunchSecondActivity=
                (Button) findViewById(R.id.buttonLaunchSecondActivity);
        mButtonLaunchSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get text content
                String s=mEditTextContent.getText().toString();
                //use Intent object to describe the new activity
                Intent intent=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });
    }
}
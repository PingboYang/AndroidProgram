package com.bignerdranch.android.lunchtoactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private static final String EXTRA_EDITTEXT_CONTENT="com.bignerdranch.android.lunchtoactivity2.CONTENT";
    private TextView mTextViewContent;
    private Button mButtonGoBack;
    private EditText mEditTextNumber;
    private static final String EXTRA_SECOND_TO_MAIN="com.bignerdranch.android.lunchtoactivity2.NUMBER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //the getIntent() method is available to retrieve the Extra
        String s=getIntent().getStringExtra(EXTRA_EDITTEXT_CONTENT);
        mTextViewContent=(TextView) findViewById(R.id.textFromMainActivity);
        mTextViewContent.setText(s);

        mButtonGoBack=(Button) findViewById(R.id.buttonGoBack);
        mEditTextNumber=(EditText) findViewById(R.id.numberToMain);
        mButtonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=mEditTextNumber.getText().toString();
                Intent intent=new Intent();
                intent.putExtra(EXTRA_EDITTEXT_CONTENT,s);
                //send the data back
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }
    //create a method for mainActivity to instantiate an Intent object
    public static Intent newIntent(Context packageContext, String content){
        Intent intent=new Intent(packageContext, SecondActivity.class);
        intent.putExtra(EXTRA_SECOND_TO_MAIN,content);
        return intent;
    }
    public static String getStringToMain(Intent result){
        return result.getStringExtra(EXTRA_SECOND_TO_MAIN);
    }
}
package com.example.robert.assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;



public class listintent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intentlayout);


        Bundle bundle = getIntent().getExtras();
        String data = bundle.getString("Data");

        TextView textView = (TextView) findViewById(R.id.text_in_intent);
        textView.setText(data);
    }
}

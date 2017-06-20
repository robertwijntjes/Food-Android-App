package com.example.robert.assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText name,description,time;
    String s_name,s_description,s_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = (EditText) findViewById(R.id.insert_name);
        description = (EditText) findViewById(R.id.insert_des);
        time = (EditText) findViewById(R.id.insert_dur);
        //Instantiates the UI.
    }
    public void onInsert (View view){
        try{
            String food_name = name.getText().toString();
            String food_des = description.getText().toString();
            String food_dur = time.getText().toString();
            String type = "insert";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type,food_name,food_des,food_dur);
            //Sends required data to the background worker and sets the required function based on the String type.
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Insert Error! : Connection Error Probably");
        }

    }
}

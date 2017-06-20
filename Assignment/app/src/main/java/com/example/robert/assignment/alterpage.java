package com.example.robert.assignment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.spec.ECField;

public class alterpage extends AppCompatActivity {
    EditText food,des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterpage_xml);
        food = (EditText) findViewById(R.id.food_name_txt);
        des = (EditText) findViewById(R.id.c_des);
        //Instantiates the UI.
    }

    public void onAlter(View view){
        try{
            String name = food.getText().toString();
            String description = des.getText().toString();
            String type = "update";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type,name,description);
            //Sends required data to the background worker and sets the required function based on the String type.
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Update Failed! : Connection Error Probably");
        }


    }
}

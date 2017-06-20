package com.example.robert.assignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class deletepage extends AppCompatActivity {
    Button delete_btn;
    EditText name_this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletepage_xml);
        delete_btn = (Button) findViewById(R.id.confirm);
        name_this = (EditText) findViewById(R.id.deletetext);
        //Instantiates the UI
    }

    public void onDelete(View view){
        try{
            String name_text = name_this.getText().toString();
            String type = "delete";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type,name_text);
            //Sends required data to the background worker and sets the required function based on the String type.
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Delete Error! : Connection Error Probably.");
        }

    }

}

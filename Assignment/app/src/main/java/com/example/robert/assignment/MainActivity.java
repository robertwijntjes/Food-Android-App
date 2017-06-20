package com.example.robert.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.StringBufferInputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText food_name;
    TextView food_desi;
    ListView list;
    public static ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    static private int save = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        food_name = (EditText) findViewById(R.id.bar_text);
        list = (ListView) findViewById(R.id.main_list);
        //Instantiates the UI .

        arrayList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(arrayAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) list.getItemAtPosition(position);
                System.out.println(selectedItem);
                Intent intent = new Intent(getApplicationContext(),listintent.class);
                intent.putExtra("Data",selectedItem);
                startActivity(intent);
            }
        });
        //sets on item click listener.
    }



    public void OnSearch(View view)
    {
        try{
            String foodname2 = food_name.getText().toString();
            String type = "search";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type,foodname2);
            arrayAdapter.addAll(arrayList);
            arrayAdapter.notifyDataSetChanged();
            //Sends required data to the background worker and sets the required function based on the String type.
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Search Failed! : Connection Error Probably.");
        }

    }


    public void OnInsert(View view)
    {
        startActivity(new Intent(this,Main2Activity.class));
    }

    public void OnDelete(View view)
    {
        startActivity(new Intent(this,deletepage.class));
    }

    public void OnAlter(View view) { startActivity(new Intent(this,alterpage.class)); }
}


package com.example.robert.assignment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class BackgroundWorker extends AsyncTask<String,Void,String>{
    //AsyncTask allows easy threading for UI.In this case it allows the program to have queries and get their results.
    private static int selector;
    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String ... params) {

        String type = params[0];
        String search_url = "http://147.252.136.220/WDD/assignment/check.php";
        String insert_url = "http://147.252.136.220/WDD/assignment/insert.php";
        String delete_url = "http://147.252.136.220/WDD/assignment/delete.php";
        String alter_url  = "http://147.252.136.220/WDD/assignment/alter.php";
        //College 147.252.139.142
        //Home 192.168.0.7
        //Strings used for connection the the PHP local server
        if(type.equals("search"))
        try {
            selector = 1;
            String name = params[1];
            //takes variables passed in from function.
            URL url = new URL(search_url);
            //creates a new instance of the URL variable.
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //Makes a single connection request to the HTTP server
            httpURLConnection.setRequestMethod("POST");
            //Sets type to POST for data transit.
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            //set contraints of the HTTP connection.
            OutputStream outputStream = httpURLConnection.getOutputStream();
            //creates an output stream on the HTTP connection
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            //writes text to the output stream.
            String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
            //sets encoding type so that data can be sent in the correct format to the output stream.
            bufferedWriter.write(post_data);
            //write the data to the http connection
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            //Clears and Closes the Writer and then closes the output stream.
            InputStream inputStream = httpURLConnection.getInputStream();
            //sets an input stream to the http connection.
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            //sets encoding type
            String result = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null)
            {
                result += line;
            }
            //reads from the buffer
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            //closes connection completely
            return result;
            //returns the results of the http connection queries. EG: sql database query

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        else if(type.equals("insert"))
        {
            try {
                selector = 2;
                String food_name = params[1];
                String food_des = params[2];
                String food_dur = params[3];
                URL url = new URL(insert_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Name", "UTF-8") + "=" + URLEncoder.encode(food_name, "UTF-8")+"&"
                        +URLEncoder.encode("Description", "UTF-8") + "=" + URLEncoder.encode(food_des, "UTF-8")+"&"
                        +URLEncoder.encode("Time", "UTF-8") + "=" + URLEncoder.encode(food_dur, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null)
                {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("delete")) {
            try {
                selector = 3;
                String food_name_d = params[1];

                URL url = new URL(delete_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Name", "UTF-8") + "=" + URLEncoder.encode(food_name_d, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(type.equals("update")) {
            try {
                selector = 4;
                String update_name = params[1];
                String update_des = params[2];
                //System.out.println(params[1]);
                //System.out.println(params[2]);
                URL url = new URL(alter_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("Name", "UTF-8") + "=" + URLEncoder.encode(update_name, "UTF-8")+"&"
                        +URLEncoder.encode("Description", "UTF-8") + "=" + URLEncoder.encode(update_des, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();

    }

    @Override
    protected void onPostExecute(String result) {
        if(selector == 1) {
            try {
                String[] parts = result.split("#");
                for (String t : parts) {
                    System.out.println(t);
                }
                String FullText = parts[1] + "\r\n" + parts[2] + "mins\r\n" + parts[3] + "\r\n";
                alertDialog.setMessage("Results Found!");
                alertDialog.show();
                MainActivity.arrayList.add(FullText);
            }catch(Exception e){
                e.printStackTrace();
                alertDialog.setMessage("No Results Found!");
                alertDialog.show();
            }
        }
        if(selector == 2) {
            try {
                alertDialog.setMessage(result);
                alertDialog.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(selector == 3){
            try {
                alertDialog.setMessage(result);
                alertDialog.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        if(selector == 4){
            try {
                alertDialog.setMessage(result);
                alertDialog.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }



    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}

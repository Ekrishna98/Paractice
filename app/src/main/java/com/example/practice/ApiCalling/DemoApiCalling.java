package com.example.practice.ApiCalling;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practice.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DemoApiCalling extends AppCompatActivity {
    String myUrl = "https://api.github.com/user";
    TextView resultsTextView;
    ProgressDialog progressDialog;
    Button displayData;
    int index_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_api_callling);
        resultsTextView = (TextView) findViewById(R.id.results);
        displayData = (Button) findViewById(R.id.displayData);
        // implement setOnClickListener event on displayData button
        displayData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create object of MyAsyncTasks class and execute it
                MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
                myAsyncTasks.execute();
            }
        });




    }
    public class MyAsyncTasks extends AsyncTask<String, String, String>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(DemoApiCalling.this);
            progressDialog.setMessage("processing results");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected String doInBackground(String... params) {
            // Fetch data from the API in the background.
            String result = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(myUrl);
                    //open a URL coonnection
                    urlConnection = (HttpURLConnection) url.openConnection();
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isw = new InputStreamReader(in);
                    int data = isw.read();
                    while (data != -1) {
                        result += (char) data;
                        data = isw.read();
                    }
                    // return the data to onPostExecute method
                    return result;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {

            // dismiss the progress dialog after receiving data from API
            progressDialog.dismiss();
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray1 = jsonObject.getJSONArray("users");
                JSONObject jsonObject1 =jsonArray1.getJSONObject(index_no);
                String id = jsonObject1.getString("id");
                String name = jsonObject1.getString("name");
                String my_users = "User ID: "+id+"\n"+"Name: "+name;
                //Show the Textview after fetching data
                resultsTextView.setVisibility(View.VISIBLE);
                //Display data with the Textview
                resultsTextView.setText(my_users);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

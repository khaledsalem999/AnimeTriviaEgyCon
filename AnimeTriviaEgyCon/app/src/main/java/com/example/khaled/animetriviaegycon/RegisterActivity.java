package com.example.khaled.animetriviaegycon;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;

public class RegisterActivity extends AppCompatActivity {
    String DataParseUrl = "http://192.168.1.11/mobile/signup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText Fname= (EditText) findViewById(R.id.RegisterFname);
        final EditText Lname= (EditText) findViewById(R.id.RegisterLname);
        final EditText Email= (EditText) findViewById(R.id.RegisterEmail);
        final EditText Password= (EditText) findViewById(R.id.RegisterPass);

        Button Regist = (Button) findViewById(R.id.RegButton);

        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String fname=  Fname.getText().toString();
                final String lname= Lname.getText().toString();
                final String email= Email.getText().toString();
                final String password= Password.getText().toString();

                class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
                    @Override
                    protected String doInBackground(String... params) {

                        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                        nameValuePairs.add(new BasicNameValuePair("Fname", fname));
                        nameValuePairs.add(new BasicNameValuePair("Lname", lname));
                        nameValuePairs.add(new BasicNameValuePair("Email", email));
                        nameValuePairs.add(new BasicNameValuePair("Password", password));

                        try {
                            HttpClient httpClient = new DefaultHttpClient();

                            HttpPost httpPost = new HttpPost(DataParseUrl);

                            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                            HttpResponse response = httpClient.execute(httpPost);

                            HttpEntity entity = response.getEntity();

                            finish();

                        } catch (ClientProtocolException e) {

                        } catch (IOException e) {

                        }
                        return "Data Submit Successfully";
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);

                        Toast.makeText(RegisterActivity.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

                    }
                }
                SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
                sendPostReqAsyncTask.execute(fname,lname,email,password);

                startActivity(new Intent(RegisterActivity.this,RulesActivity.class));
                finish();
            }
        });


    }

}

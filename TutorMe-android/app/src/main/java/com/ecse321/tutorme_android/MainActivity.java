package com.ecse321.tutorme_android;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class MainActivity extends AppCompatActivity {
    private String error = "";
    private EditText email;
    private EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void login (View V) {
        System.out.println("hello");
        Button signIN_button = findViewById(R.id.signIN_button);
        signIN_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.get("/api/manager/getall", null, new JsonHttpResponseHandler() {
                    private JSONArray response;

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        System.out.println("i have reached here");
                        for (int i = 0; i < response.length(); i++) {

                            try {
                                JSONObject jsonobject = response.getJSONObject(i);
                                String foundEmail = jsonobject.getString("email");
                                System.out.println(foundEmail);
                                String foundPassword = jsonobject.getString("password");
                                System.out.println(foundPassword);
                                if (foundEmail == email.getText().toString()) {
                                    if (foundPassword == password.getText().toString()) {
                                        System.out.println("Account exists, we can login");
                                        startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
                                    }else{
                                        System.out.println("Invalid Username or password");
                                    }
                                }
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        try {
                            error += statusCode + " " + throwable.getMessage();
                        } catch (Exception e) {
                            error += e.getMessage();
                        }
                    }
                });


            }
        });
        final TextView signUp_text = findViewById(R.id.signUp_text);

        email.getText().toString();
        password.getText().toString();
        signUp_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

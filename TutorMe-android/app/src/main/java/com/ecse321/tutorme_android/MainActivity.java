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
import cz.msebera.android.httpclient.Header;

/**
 * This class represents behaviour for the main activity on launch.
 * i.e. the login screen
 */
public class MainActivity extends AppCompatActivity {
    private String error = null;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        refreshErrorMessage();
    }
    private void refreshErrorMessage() {
        // set the error message
        TextView tvError = (TextView) findViewById(R.id.error);
        tvError.setText(error);

        if (error == null || error.length() == 0) {
            tvError.setVisibility(View.GONE);
        } else {
            tvError.setVisibility(View.VISIBLE);
        }
    }
    public void login (View V) {
        error = "";
        Button signIN_button = findViewById(R.id.signIN_button);
        signIN_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.get("/api/manager/getall", null, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                if (email.getText().toString() == null || email.getText().toString().equals("") || password.getText().toString()==null || password.getText().toString() .equals( "")){
                                    error="You have not entered an email or password";
                                    refreshErrorMessage();
                                    return;
                                }
                                JSONObject jsonobject = response.getJSONObject(i);
                                String foundEmail = jsonobject.getString("email");
                                String foundPassword = jsonobject.getString("password");
                                if (foundEmail.equals(email.getText().toString())) {
                                    if (foundPassword.equals(password.getText().toString())) {
                                        error += "Account Exists! Logging you in";
                                        refreshErrorMessage();
                                        startActivity(new Intent(MainActivity.this, Homepage.class));
                                    }else{
                                        error = "Invalid Username/Password";
                                        refreshErrorMessage();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        error += statusCode + " " + throwable.getMessage();
                        refreshErrorMessage();
                    }
                });
            }
        });
        final TextView signUp_text = findViewById(R.id.signUp_text);

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

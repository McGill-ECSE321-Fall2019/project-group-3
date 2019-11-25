package com.ecse321.tutorme_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class RegistrationActivity extends AppCompatActivity {
    private String error = null;
    private EditText email;
    private EditText password;
    private EditText firstName;
    private EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
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

    public void registration(View V) {
        error = "";
        Button signUp_button = findViewById(R.id.registration_button);
        final TextView loginText = findViewById(R.id.login_text);
        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                finish();
            }
        });

        final JSONObject requestObject = new JSONObject();
        try {
            requestObject.put("email", email.getText().toString());
            requestObject.put("password", password.getText().toString());
            requestObject.put("firstName", firstName.getText().toString());
            requestObject.put("lastName", lastName.getText().toString());
            requestObject.put("payroll", null);
            requestObject.put("verified", true);
        } catch (Exception e) {
            System.out.println("nope");
        }
        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.get("/api/manager/getall", null, new JsonHttpResponseHandler() {
                    private JSONArray response;

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonobject = response.getJSONObject(i);
                                String foundEmail = jsonobject.getString("email");
                                if (foundEmail.equals(email.getText().toString())) {
                                    error = "An account already exists with that email";
                                    refreshErrorMessage();
                                } else {
                                    StringEntity jsonEntity = new StringEntity(requestObject.toString());
                                    HttpUtils.postJson("/api/manager", jsonEntity, new JsonHttpResponseHandler() {
                                        @Override
                                        public void onSuccess(int statusCode, Header[] headers, String response) {
                                            error = "Account Registered! Please return to login";
                                            refreshErrorMessage();
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
                            } catch (Exception e) {
                                error += e.getMessage();
                            }
                        }
                    }
                });
            }
        });
    }
}


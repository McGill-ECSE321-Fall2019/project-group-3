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
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
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
            System.out.println("JSON Object error");
            return;
        }
        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                        StringEntity jsonEntity = new StringEntity(requestObject.toString());
                    HttpUtils.postJson("/api/manager", jsonEntity, new JsonHttpResponseHandler(){

                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            error += statusCode+" " + throwable.getMessage();
                            refreshErrorMessage();
                        }
                    });
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
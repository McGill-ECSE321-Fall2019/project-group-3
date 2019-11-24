package com.ecse321.tutorme_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

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
    }

    public void registration(View V) throws JSONException {
        error = "";
        TextView signUp_button = findViewById(R.id.signUp_button);
        email.getText().toString();
        password.getText().toString();
        firstName.getText().toString();
        lastName.getText().toString();
        final JSONObject requestObject = new JSONObject();
        requestObject.put("email", email);
        requestObject.put("password", password);
        requestObject.put("firstName", firstName);
        requestObject.put("lastName", lastName);
        requestObject.put("payroll", null);
        requestObject.put("verified", true);
        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    StringEntity jsonEntity = new StringEntity(requestObject.toString());
                    HttpUtils.postJson("/api/manager", jsonEntity, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            System.out.println("We have succeeded");
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            System.out.println("we have failed");
                        }
                    });
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}

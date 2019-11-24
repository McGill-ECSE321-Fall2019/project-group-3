package com.ecse321.tutorme_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

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

    public void registration(View V)  {
        error = "";
        Button signUp_button = findViewById(R.id.signUp_button);
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
        } catch (Exception e){
            System.out.println("nope");
        }
        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    StringEntity jsonEntity = new StringEntity(requestObject.toString());
                    HttpUtils.postJson("/api/manager", jsonEntity, new JsonHttpResponseHandler(){
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, String response) {
                            error += "Success";

                        }
                        @Override
                        public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                            try {
                                error += statusCode+" " + throwable.getMessage();
                            } catch (Exception e) {
                                error += e.getMessage();
                            }
                        }
                    });
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}

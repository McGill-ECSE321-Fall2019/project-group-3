package com.ecse321.tutorme_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.ecse321.tutorme_android.University.UniversityActivity;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import cz.msebera.android.httpclient.Header;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class Homepage extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView textView = findViewById(R.id.homepage_text);
        textView.setText("Welcome to TutorME!");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        }
        setCalendarEvents();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setCalendarEvents() {
        System.out.println("setting up calendar");
        final CompactCalendarView compactCalendarView = findViewById(R.id.compactcalendar_view);
        //fetch from backend and set.
        HttpUtils.get("/api/lesson/getall", new RequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                if (statusCode != 200) return;

                for (int i = 0; i < response.length(); i++) {
                    try {
                        final JSONObject lessonObj = response.getJSONObject(i);
                        final int lessonId = lessonObj.getInt("lessonId");

                        RequestParams requestParams = new RequestParams();
                        requestParams.put("lessonId", lessonId);
                        HttpUtils.get("/api/lesson/getCourseRoom", requestParams,
                                new JsonHttpResponseHandler() {
                                    @Override
                                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                        createEvent(compactCalendarView, lessonObj, response);
                                    }

                                    @Override
                                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

                                    }
                                });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

            }
        });
        //color, time, and data.
        setUpListeners(compactCalendarView);
    }

    public void setUpListeners(final CompactCalendarView compactCalendarView) {
        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDayClick(Date dateClicked) {
                compactCalendarView.getEvents(dateClicked).forEach(event -> {
                    Context context = getApplicationContext();
                    Toast.makeText(context, event.getData().toString(), Toast.LENGTH_SHORT).show();
                });
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createEvent(final CompactCalendarView compactCalendarView, JSONObject lessonObj, JSONObject courseRoomResp) {
        System.out.println("created as well");
        try {
            System.out.println(lessonObj.getInt("lessonId"));

            String courseName = null;
            Integer roomId = null;

            if (!courseRoomResp.isNull("course") && !courseRoomResp.getJSONObject("course").isNull("courseName")) {
                courseName = courseRoomResp.getJSONObject("course").getString("courseName");
            }

            if (!courseRoomResp.isNull("room") && !courseRoomResp.getJSONObject("room").isNull("room_id")) {
                roomId = courseRoomResp.getJSONObject("room").getInt("room_id");
            }

            StringBuilder sb = new StringBuilder();
            if (courseName != null) sb.append(courseName + " ");
            if (roomId != null) sb.append("at Room #:" + roomId.intValue());

            if (sb.length() == 0) sb.append("Lesson #" + lessonObj.getInt("lessonId"));

            String date = lessonObj.getString("startTime");
            long dateLong = LocalDateTime.parse(date).toEpochSecond(ZoneOffset.UTC);
            dateLong *= 1000;
            Event event = new Event(Color.GREEN, dateLong, sb.toString().trim());
            compactCalendarView.addEvent(event);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void navigateToTutors(View v) {
        Button tutorButtons = findViewById(R.id.button4);
        tutorButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, TutorActivity.class));
            }
        });
    }

    public void navigateToStudents(View v) {
        Button studentButton = findViewById(R.id.button5);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, StudentActivity.class));
            }
        });
    }

    public void navigateToUniversities(View v) {
        Button uniButton = findViewById(R.id.button6);
        uniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, UniversityActivity.class));
            }
        });
    }
}


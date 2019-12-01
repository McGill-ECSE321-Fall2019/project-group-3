package com.ecse321.tutorme_android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.ecse321.tutorme_android.University.UniversityActivity;
import com.ecse321.tutorme_android.Course.CourseActivity;
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

/**
 * This class represents behaviour for the HomePage screen, i.e. after login.
 */
public class Homepage extends AppCompatActivity {

    /**
     * This method configures layout and initiates the loading of calendar events from backend.
     * @param savedInstanceState
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = findViewById(R.id.homepage_text);
        textView.setText("Welcome to TutorME!");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            textView.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        }
        setCalendarEvents();
    }

    /**
     * Fetches all lessons from backend.
     * On success of call, parses lessons, and makes another call to retrieve their courses and rooms.
     * createEvent() is then initiated to add lesson to calendar.
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setCalendarEvents() {
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

    /**
     * This method takes in a reference to CalendarView and adds an onClick listener for date clicked.
     * @param compactCalendarView
     */
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

    /**
     * The createEvent method takes references to the calendarView, and JSONObjects retrieved from backend.
     * The objects are parsed into View-Friendly Text and configured to be added to the calendar.
     * @param compactCalendarView
     * @param lessonObj
     * @param courseRoomResp
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void createEvent(final CompactCalendarView compactCalendarView, JSONObject lessonObj, JSONObject courseRoomResp) {
        try {
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

    /**
     * This method takes a reference to the View and navigates to TutorActivity onClick of respective button.
     * @param v
     */
    public void navigateToTutors(View v) {
        Button tutorButtons = findViewById(R.id.button4);
        tutorButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, TutorActivity.class));
            }
        });
    }
    /**
     * This method takes a reference to the View and navigates to StudentActivity onClick of respective button.
     * @param v
     */
    public void navigateToStudents(View v) {
        Button studentButton = findViewById(R.id.button5);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, StudentActivity.class));
            }
        });
    }
    /**
     * This method takes a reference to the View and navigates to UniversityActivity onClick of respective button.
     * @param v
     */
    public void navigateToUniversities(View v) {
        Button uniButton = findViewById(R.id.button6);
        uniButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, UniversityActivity.class));
            }
        });
    }

    public void navigateToCourses(View v) {
        Button coursesButton = findViewById(R.id.button7);
        coursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, CourseActivity.class));
            }
        });
    }
}


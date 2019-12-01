package com.ecse321.tutorme_android.Course;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecse321.tutorme_android.HttpUtils;
import com.ecse321.tutorme_android.R;
import com.ecse321.tutorme_android.Course.CourseAdapter;
import com.ecse321.tutorme_android.Course.model.CourseModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class CourseActivity extends AppCompatActivity {

    RecyclerView uRecyclerView;
    CourseAdapter courseAdapter;

    /**
     * The Course onCreate function sets the toolbar layout and begins call to fetch course data.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Courses");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        uRecyclerView = findViewById(R.id.recyclerview);
        uRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        courseAdapter = new CourseAdapter(this, fetchList());
        uRecyclerView.setAdapter(courseAdapter);
    }

    /**
     * Makes call to /api/university/getall, and receives all universities.
     * The received objects are parsed by this function into a model for the view.
     * @return void
     */
    private ArrayList<CourseModel> fetchList(){
        ArrayList<CourseModel> models = new ArrayList<>();

        //make the call, convert all to UniModel and then add to the list.
        HttpUtils.get("/api/subject/getall", new RequestParams(), new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray responseArray){

                for(int i = 0; i<responseArray.length(); i++){
                    try {
                        JSONObject jsonObj = responseArray.getJSONObject(i);
                        String subjectTitle = jsonObj.getString("subject_name");
                        List<String> subjectNames = new ArrayList<>();
                        if(jsonObj.getJSONArray("courses").length()!=0){
                            JSONArray subjectArray = jsonObj.getJSONArray("courses");
                            for(int j = 0; j<subjectArray.length(); j++){
                                try{
                                    JSONObject subjectObj = subjectArray.getJSONObject(j);
                                    subjectNames.add(subjectObj.getString("courseName"));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        System.out.println(subjectTitle);
                        models.add(new CourseModel(subjectTitle, subjectNames));
                        courseAdapter.notifyDataSetChanged();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

            }
        });
        return models;
    }
}

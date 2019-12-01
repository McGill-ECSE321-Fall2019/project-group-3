package com.ecse321.tutorme_android.University;

import android.os.Bundle;

import com.ecse321.tutorme_android.HttpUtils;
import com.ecse321.tutorme_android.R;
import com.ecse321.tutorme_android.University.model.UniModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cz.msebera.android.httpclient.Header;

import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityActivity extends AppCompatActivity {

    RecyclerView uRecyclerView;
    UniAdapter uniAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Universities");

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

        uniAdapter = new UniAdapter(this, fetchList());
        uRecyclerView.setAdapter(uniAdapter);
    }

    private ArrayList<UniModel> fetchList(){
        ArrayList<UniModel> models = new ArrayList<>();

        //make the call, convert all to UniModel and then add to the list.
        HttpUtils.get("/api/university/getall", new RequestParams(), new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray responseArray){
                for(int i = 0; i<responseArray.length(); i++){
                    try {
                        JSONObject jsonObj = responseArray.getJSONObject(i);
                        String uniTitle = jsonObj.getString("university_name");
                        List<String> subjectNames = new ArrayList<>();
                        if(jsonObj.getJSONArray("subjects").length()!=0){
                            JSONArray subjectArray = jsonObj.getJSONArray("subjects");
                            for(int j = 0; j<subjectArray.length(); j++){
                                try{
                                    JSONObject subjectObj = subjectArray.getJSONObject(j);
                                    subjectNames.add(subjectObj.getString("subject_name"));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        models.add(new UniModel(uniTitle, subjectNames));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                uniAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

            }
        });
       // addTests(models);
        return models;
    }

    private void addTests(ArrayList<UniModel> models){
        List<String> sampleCourses = new ArrayList<>();
        sampleCourses.add("Course1");
        sampleCourses.add("Course2");
        sampleCourses.add("Course3");
        models.add(new UniModel("Test University", sampleCourses));
        models.add(new UniModel("Test2 University", sampleCourses));
        models.add(new UniModel("Test3 University", sampleCourses));
        models.add(new UniModel("Test4 University", sampleCourses));
        models.add(new UniModel("Test5 University", sampleCourses));
        models.add(new UniModel("Test6 University", sampleCourses));
        models.add(new UniModel("Test7 University", sampleCourses));
        models.add(new UniModel("Test8 University", sampleCourses));
        models.add(new UniModel("Test9 University", sampleCourses));
        models.add(new UniModel("Test10 University", sampleCourses));
    }
}

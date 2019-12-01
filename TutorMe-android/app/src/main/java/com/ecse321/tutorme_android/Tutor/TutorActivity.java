package com.ecse321.tutorme_android.Tutor;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ecse321.tutorme_android.HttpUtils;
import com.ecse321.tutorme_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class TutorActivity extends AppCompatActivity {


    RecyclerView tutorRecyclerView;
    TutorAdapter tutorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tutors");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tutorRecyclerView = findViewById(R.id.recyclerview);
        tutorRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tutorAdapter = new TutorAdapter(this, fetchList());
        tutorRecyclerView.setAdapter(tutorAdapter);
    }

    private ArrayList<TutorModel> fetchList(){
        ArrayList<TutorModel> models = new ArrayList<>();

        //make the call, convert all to UniModel and then add to the list.
        HttpUtils.get("/api/tutor/getall", new RequestParams(), new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray responseArray){
                for(int i = 0; i<responseArray.length(); i++){
                    try {
                        JSONObject jsonObj = responseArray.getJSONObject(i);
                        String firstName = jsonObj.getString("firstName");
                        String lastName = jsonObj.getString("lastName");
                        String email = jsonObj.getString("email");
                        List<String> reviewComments = new ArrayList<>();
                        if(jsonObj.getJSONArray("reviews").length()!=0){
                            JSONArray reviewArray = jsonObj.getJSONArray("reviews");
                            for(int j = 0; j<reviewArray.length(); j++){
                                try{
                                    JSONObject subjectObj = reviewArray.getJSONObject(j);
                                    reviewComments.add(subjectObj.getString("comment"));
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        }
                        models.add(new TutorModel(firstName, lastName, email, reviewComments));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
                tutorAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

            }
        });
        // addTests(models);
        return models;
    }

    private void addTests(ArrayList<TutorModel> models){
        List<String> sampleReviews = new ArrayList<>();
        sampleReviews.add("Review1");
        sampleReviews.add("Revirew2");
        sampleReviews.add("Review3");
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
        models.add(new TutorModel("John", "Doe", "test@email.com" ,sampleReviews));
    }

}

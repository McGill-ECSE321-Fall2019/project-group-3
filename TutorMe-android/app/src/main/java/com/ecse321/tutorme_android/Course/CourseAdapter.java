package com.ecse321.tutorme_android.Course;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecse321.tutorme_android.R;
import com.ecse321.tutorme_android.Course.model.CourseModel;

import java.util.ArrayList;

/*
This class dictates the adapter for the Universities.
i.e. handles the data flow from strings to the respective components.
 */
public class CourseAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context c;
    ArrayList<CourseModel> models;

    public CourseAdapter(Context c, ArrayList<CourseModel> models) {
        this.c = c;
        this.models = models;
    }

    /**
     * Initializes the View Holder with the courserow.xml configuration
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from
                (parent.getContext())
                .inflate(R.layout.course_row, null));
    }

    /**
     * Sets the titleView for Course Card Views to their String values.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titleView.setText(models.get(position).getSubjectTitle());

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(String course: this.models.get(position).getCourseNames()){
            sb.append("\u2022  " + this.models.get(position).getCourseNames().get(index++) + "\n");
        }

        holder.coursesView.setText(sb.toString());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}

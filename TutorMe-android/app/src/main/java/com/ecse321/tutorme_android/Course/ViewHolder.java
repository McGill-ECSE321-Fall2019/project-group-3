package com.ecse321.tutorme_android.Course;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecse321.tutorme_android.R;

/*
ViewHolder for the RecyclerView.
Each Course Card (View) has a title, and a list of subjects.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    TextView titleView;
    TextView coursesView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        this.titleView = itemView.findViewById(R.id.subjectName);
        this.coursesView = itemView.findViewById(R.id.coursesText);


    }


}

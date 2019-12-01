package com.ecse321.tutorme_android.University;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.ecse321.tutorme_android.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/*
ViewHolder for the RecyclerView.
Each University Card (View) has a title, and a spinner for subject.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    TextView titleView;
    Spinner subjectSpinner;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        this.titleView = itemView.findViewById(R.id.titleUni);
        this.subjectSpinner = itemView.findViewById(R.id.spinner_subjects);
    }


}

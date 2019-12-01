package com.ecse321.tutorme_android.Tutor;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecse321.tutorme_android.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView nameView;
    TextView emailView;
    TextView reviewView;
    Spinner reviewSpinner;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        this.nameView = itemView.findViewById(R.id.tutorName);
        this.emailView = itemView.findViewById(R.id.tutorEmail);
        this.reviewSpinner = itemView.findViewById(R.id.reviewSpinner);
    }


}

package com.ecse321.tutorme_android.Student;

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

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        this.nameView = itemView.findViewById(R.id.studentName);
        this.emailView = itemView.findViewById(R.id.studentEmail);
        this.reviewView = itemView.findViewById(R.id.reviewComment);
    }


}

package com.ecse321.tutorme_android.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ecse321.tutorme_android.R;
import com.ecse321.tutorme_android.Student.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context c;
    ArrayList<StudentModel> models;

    public StudentAdapter(Context c, ArrayList<StudentModel> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from
                (parent.getContext())
                .inflate(R.layout.studentrow, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameView.setText(models.get(position).getFirstName() + ' ' + models.get(position).getLastName() );
        holder.emailView.setText(models.get(position).getEmail());
        StringBuilder sb = new StringBuilder();
        if(models.get(position).getReviewComments().size() != 0) sb.append("Student reviews: \n \n" );
        int index = 0;
        for(String comment: models.get(position).getReviewComments()){
            sb.append("\u2022  " + models.get(position).getReviewComments().get(index++) + "\n");
        }
        holder.reviewView.setText(sb.toString());
    }
    @Override
    public int getItemCount() {
        return models.size();
    }
}

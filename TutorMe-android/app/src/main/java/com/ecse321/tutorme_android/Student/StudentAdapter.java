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
                .inflate(R.layout.unirow, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nameView.setText(models.get(position).getFirstName() + ' ' + models.get(position).getLastName() );

        //add to spinner
        List<String> items_subs = models.get(position).getReviewComments();
        String[] items = items_subs.toArray(new String[0]);
        ArrayAdapter<String> subject_adapter = new ArrayAdapter<>(c, android.R.layout.simple_spinner_dropdown_item, items);
        holder.reviewSpinner.setAdapter(subject_adapter);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}

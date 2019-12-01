package com.ecse321.tutorme_android.University;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.ecse321.tutorme_android.R;
import com.ecse321.tutorme_android.University.model.UniModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/*
This class dictates the adapter for the Universities.
i.e. handles the data flow from strings to the respective components.
 */
public class UniAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context c;
    ArrayList<UniModel> models;

    public UniAdapter(Context c, ArrayList<UniModel> models) {
        this.c = c;
        this.models = models;
    }

    /**
     * Initializes the View Holder with the unirow.xml configuration
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from
                (parent.getContext())
                .inflate(R.layout.unirow, null));
    }

    /**
     * Sets the titleView and Spinners for University Card Views to their respective String values.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titleView.setText(models.get(position).getUniversityTitle());

        //add to spinner
        List<String> items_subs = models.get(position).getSubjectNames();
        String[] items = items_subs.toArray(new String[0]);
        ArrayAdapter<String> subject_adapter = new ArrayAdapter<>(c, android.R.layout.simple_spinner_dropdown_item, items);
        holder.subjectSpinner.setAdapter(subject_adapter);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}

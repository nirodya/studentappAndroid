package javainstitute.edu.lk.studentapp.model;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import javainstitute.edu.lk.studentapp.R;

/**
 * Created by Nirodya on 3/30/2016.
 */
public class SubjectsAdapter extends RecyclerView.Adapter<SubjectsAdapter.SubjectsViewHolder> {
    private ArrayList<Subject> subjectsList;

    public SubjectsAdapter(ArrayList<Subject> subjectsList) {
        this.subjectsList = subjectsList;
    }

    @Override
    public SubjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subjects_list_row, parent, false);
        return new SubjectsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubjectsViewHolder holder, int position) {
        Log.d("holder",position+"");
        Subject subject=subjectsList.get(position);
        holder.subject_text.setText(subject.getSubject());
    }

    @Override
    public int getItemCount() {
        return subjectsList.size();
    }

    public class SubjectsViewHolder extends RecyclerView.ViewHolder {
        public TextView subject_text;
        public SubjectsViewHolder(View itemView) {
            super(itemView);
            subject_text= (TextView) itemView.findViewById(R.id.subject_text);
        }
    }
}

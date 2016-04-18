package javainstitute.edu.lk.studentapp.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import javainstitute.edu.lk.studentapp.R;

/**
 * Created by Nirodya on 3/30/2016.
 */
public class MarkAdapter extends RecyclerView.Adapter<MarkAdapter.MarkHolder> {
    private ArrayList<Mark> marks;

    public MarkAdapter(ArrayList<Mark> marks) {
        this.marks = marks;
    }

    @Override
    public MarkHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.marks_list_row, parent, false);
        return new MarkHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MarkHolder holder, int position) {
        Mark mark=marks.get(position);
        holder.mark_mark.setText(mark.getMark());
        holder.mark_subject.setText(mark.getSubject());
        holder.mark_date.setText(mark.getDate());
    }

    @Override
    public int getItemCount() {
        return marks.size();
    }

    public class MarkHolder extends RecyclerView.ViewHolder {
        TextView mark_subject,mark_mark,mark_date;
        public MarkHolder(View itemView) {
            super(itemView);
            mark_date= (TextView) itemView.findViewById(R.id.mark_date);
            mark_subject= (TextView) itemView.findViewById(R.id.mark_subject);
            mark_mark= (TextView) itemView.findViewById(R.id.mark_mark);
        }
    }
}

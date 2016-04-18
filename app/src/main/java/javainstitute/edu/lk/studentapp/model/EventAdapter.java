package javainstitute.edu.lk.studentapp.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import javainstitute.edu.lk.studentapp.R;

/**
 * Created by Nirodya on 3/31/2016.
 */
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {
    ArrayList<EventPOJO> eventPOJOs;

    public EventAdapter(ArrayList<EventPOJO> eventPOJOs) {
        this.eventPOJOs = eventPOJOs;
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.evants_list_row, parent, false);
        return new EventHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        EventPOJO eventPOJO=eventPOJOs.get(position);
        holder.evennametext.setText(eventPOJO.getEventName());
    }

    @Override
    public int getItemCount() {
        return eventPOJOs.size();
    }

    public class EventHolder extends RecyclerView.ViewHolder {
        TextView evennametext;
        public EventHolder(View itemView) {
            super(itemView);
            evennametext= (TextView) itemView.findViewById(R.id.evennametext);
        }
    }
}

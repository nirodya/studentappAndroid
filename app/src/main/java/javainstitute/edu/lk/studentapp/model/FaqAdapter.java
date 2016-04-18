package javainstitute.edu.lk.studentapp.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import javainstitute.edu.lk.studentapp.R;

/**
 * Created by Nirodya on 3/31/2016.
 */
public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {
    private ArrayList<FaqPOJO> faqPOJOs;

    public FaqAdapter(ArrayList<FaqPOJO> faqPOJOs) {
        this.faqPOJOs = faqPOJOs;
    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.faq_question_row, parent, false);
        return new FaqViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {
        FaqPOJO faqPOJO=faqPOJOs.get(position);
        holder.faqquestiontext.setText(faqPOJO.getQuestion());
        holder.faqanswertext.setText(faqPOJO.getAnswer());
    }

    @Override
    public int getItemCount() {
        return faqPOJOs.size();
    }

    public class FaqViewHolder extends RecyclerView.ViewHolder {
        TextView faqquestiontext,faqanswertext;
        LinearLayout linearLayout;
        public FaqViewHolder(View itemView) {
            super(itemView);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.farowmain);
            faqanswertext= (TextView) itemView.findViewById(R.id.faqanswertext);
            faqquestiontext= (TextView) itemView.findViewById(R.id.faqquestiontext);
//            faqanswertext.setVisibility(View.GONE);
//            linearLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
        }
    }
}

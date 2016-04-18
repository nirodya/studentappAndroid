package javainstitute.edu.lk.studentapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import controller.CallEvents;
import javainstitute.edu.lk.studentapp.model.EventAdapter;
import javainstitute.edu.lk.studentapp.model.EventPOJO;
import javainstitute.edu.lk.studentapp.model.FaqAdapter;
import javainstitute.edu.lk.studentapp.model.FaqPOJO;

public class EventsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private ArrayList<EventPOJO> eventPOJOs;
    private EventAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView= (RecyclerView) findViewById(R.id.eventrecycler);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setTitle("Loading");
        progressDialog.show();

        eventPOJOs=new ArrayList<>();

        CallEvents callEvents=new CallEvents(eventPOJOs,EventsActivity.this);
        callEvents.execute();

        mAdapter=new EventAdapter(eventPOJOs);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    public void processData(){
        mAdapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

}

package javainstitute.edu.lk.studentapp;

import android.app.ProgressDialog;
import android.content.Intent;
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

import controller.CallMarks;
import javainstitute.edu.lk.studentapp.model.Mark;
import javainstitute.edu.lk.studentapp.model.MarkAdapter;
import javainstitute.edu.lk.studentapp.model.SubjectsAdapter;

public class ViewMarks extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MarkAdapter mAdapter;
    private ProgressDialog progressDialog;
    private ArrayList<Mark> marks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        marks=new ArrayList<>();

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setTitle("Loading");
        progressDialog.show();

        Intent intent=getIntent();
        String nic=intent.getStringExtra("nic");
        CallMarks callMarks=new CallMarks(nic,marks,ViewMarks.this);
        callMarks.execute();

        recyclerView= (RecyclerView) findViewById(R.id.marksrecycler);

        mAdapter=new MarkAdapter(marks);
        recyclerView= (RecyclerView) findViewById(R.id.marksrecycler);
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

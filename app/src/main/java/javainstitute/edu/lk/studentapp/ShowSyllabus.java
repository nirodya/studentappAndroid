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

import controller.CallSubjects;
import javainstitute.edu.lk.studentapp.model.Subject;
import javainstitute.edu.lk.studentapp.model.SubjectsAdapter;

public class ShowSyllabus extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SubjectsAdapter mAdapter;
    private ArrayList<Subject> subjects;
    private ProgressDialog progressDialog;
    private int yid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_syllabus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();
        yid=intent.getIntExtra("yid",0);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setTitle("Loading");
        progressDialog.show();

        subjects=new ArrayList<>();
        CallSubjects callSubjects=new CallSubjects(yid+"",subjects,ShowSyllabus.this);
        callSubjects.execute();


        mAdapter=new SubjectsAdapter(subjects);
        recyclerView= (RecyclerView) findViewById(R.id.showsylabusrecycler);
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

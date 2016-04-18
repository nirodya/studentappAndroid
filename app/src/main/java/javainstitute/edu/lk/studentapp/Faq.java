package javainstitute.edu.lk.studentapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import controller.CallFaqs;
import javainstitute.edu.lk.studentapp.model.FaqAdapter;
import javainstitute.edu.lk.studentapp.model.FaqPOJO;

public class Faq extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    private ArrayList<FaqPOJO> faqPOJOs;
    private FaqAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView= (RecyclerView) findViewById(R.id.faqrecycle);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setTitle("Loading");
        progressDialog.show();

        faqPOJOs=new ArrayList<>();
        CallFaqs callFaqs=new CallFaqs(faqPOJOs,Faq.this);
        callFaqs.execute();

        mAdapter=new FaqAdapter(faqPOJOs);
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

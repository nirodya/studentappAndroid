package javainstitute.edu.lk.studentapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import controller.CallMailComplaint;

public class Complaint extends AppCompatActivity {
    private EditText compliant_subject;
    private EditText complaint_matter;
    private Button complaint_button;
    private ProgressDialog progressBar;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        compliant_subject= (EditText) findViewById(R.id.compliant_subject);
        complaint_matter= (EditText) findViewById(R.id.complaint_matter);
        complaint_button= (Button) findViewById(R.id.complaint_button);
        linearLayout= (LinearLayout) findViewById(R.id.complaint_layout);
        progressBar=new ProgressDialog(this);
        complaint_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setMessage("Sending your complaint....");
                progressBar.setTitle("Please Wait");
                progressBar.show();
                Log.d("CALLEDD","CALLEED");
                CallMailComplaint callMailComplaint=new CallMailComplaint(compliant_subject.getText().toString(),complaint_matter.getText().toString(),Complaint.this);
                callMailComplaint.execute();
            }
        });
    }

    public void closeProgressBar(String text){
        progressBar.dismiss();
        Snackbar snackbar = Snackbar
                .make(linearLayout, text, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case android.R.id.home:
                //do your action here.
                onBackPressed();
                break;
        }

        return true;
    }

}

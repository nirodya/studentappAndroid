package javainstitute.edu.lk.studentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Syllabus extends AppCompatActivity {
    private ListView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView= (ListView) findViewById(R.id.yearlist);
        ArrayList<String> year=new ArrayList<>();
        year.add("Year One");
        year.add("Year Two");
        year.add("Year Three");
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(Syllabus.this,android.R.layout.simple_list_item_1,year);
        recyclerView.setAdapter(stringArrayAdapter);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int yid;
                if (position == 0) {
                    yid = 1;
                } else if (position == 1) {
                    yid = 2;
                } else {
                    yid = 3;
                }
                Intent intent=new Intent(Syllabus.this,ShowSyllabus.class);
                intent.putExtra("yid",yid);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}

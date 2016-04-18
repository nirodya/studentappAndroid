package controller;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javainstitute.edu.lk.studentapp.ShowSyllabus;
import javainstitute.edu.lk.studentapp.model.Subject;

/**
 * Created by Nirodya on 3/30/2016.
 */
public class CallSubjects extends AsyncTask {
    private String yid;
    private String res;
    private ArrayList<Subject> subjects;
    private ShowSyllabus showSyllabus;

    public CallSubjects(String yid, ArrayList<Subject> subjects, ShowSyllabus showSyllabus) {
        this.yid = yid;
        this.subjects = subjects;
        this.showSyllabus = showSyllabus;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        try {
            JSONArray jsonArray=new JSONArray(res);
            Log.d("RESSS",jsonArray.toString());
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject= (JSONObject) jsonArray.get(i);
                Log.d("Decoded", jsonObject.toString());
                Subject subject=new Subject(jsonObject.getString("subject"));
                subjects.add(subject);
            }
            showSyllabus.processData();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected Object doInBackground(Object[] params) {
        try{
            StringBuilder stringBuilder=new StringBuilder(NetworkDetails._URL+"GetSubjects");
            stringBuilder.append("?yid=" + yid);
            URL url=new URL(stringBuilder.toString());
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(httpURLConnection.getInputStream());
            StringBuilder jsonResults=new StringBuilder();
            // Load the results into a StringBuilder
            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
            res=jsonResults.toString();
            Log.d("CONN", stringBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

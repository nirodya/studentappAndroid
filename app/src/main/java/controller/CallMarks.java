package controller;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javainstitute.edu.lk.studentapp.ViewMarks;
import javainstitute.edu.lk.studentapp.model.Mark;

/**
 * Created by Nirodya on 3/30/2016.
 */
public class CallMarks extends AsyncTask {
    private String NIC;
    private String res;
    private ArrayList<Mark> markses;
    private ViewMarks viewMarks;

    public CallMarks(String NICs,ArrayList<Mark> markses,ViewMarks viewMarks) {
        this.NIC = NICs;
        this.markses=markses;
        this.viewMarks=viewMarks;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        try {
            JSONArray jsonArray=new JSONArray(res);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                Mark mark=new Mark(jsonObject.getString("mark"),jsonObject.getString("date"),jsonObject.getString("stu_name"),jsonObject.getString("subject"));
                markses.add(mark);
            }
            viewMarks.processData();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try{
            StringBuilder stringBuilder=new StringBuilder(NetworkDetails._URL+"GetMarks");
            stringBuilder.append("?nic=" + NIC);
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

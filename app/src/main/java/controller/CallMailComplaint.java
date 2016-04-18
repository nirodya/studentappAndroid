package controller;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

import javainstitute.edu.lk.studentapp.Complaint;

/**
 * Created by Nirodya on 3/30/2016.
 */
public class CallMailComplaint extends AsyncTask {
    private String subject;
    private String matter;
    private Complaint complaint;

    public CallMailComplaint(String subject, String matter, Complaint complaint) {
        this.subject = subject;
        this.matter = matter;
        this.complaint = complaint;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        complaint.closeProgressBar("Complaint Placed successfully");
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try{
            StringBuilder stringBuilder=new StringBuilder(NetworkDetails._URL+"SendComplaint");
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("key",NetworkDetails.key);
            jsonObject.put("subject",subject);
            jsonObject.put("matter", matter);

            stringBuilder.append("?data=" + jsonObject.toString());
            URL url=new URL(stringBuilder.toString());
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.getInputStream();
            Log.d("CONN",stringBuilder.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

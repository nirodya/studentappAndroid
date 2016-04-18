package controller;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javainstitute.edu.lk.studentapp.EventsActivity;
import javainstitute.edu.lk.studentapp.model.EventPOJO;

/**
 * Created by Nirodya on 3/31/2016.
 */
public class CallEvents extends AsyncTask {
    private ArrayList<EventPOJO> eventPOJOs;
    private EventsActivity eventsActivity;
    private String res;

    public CallEvents(ArrayList<EventPOJO> eventPOJOs, EventsActivity eventsActivity) {
        this.eventPOJOs = eventPOJOs;
        this.eventsActivity = eventsActivity;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        try {
            JSONArray jsonArray=new JSONArray(res);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                EventPOJO eventPOJO=new EventPOJO(jsonObject.getString("idevents"),jsonObject.getString("eventname"),jsonObject.getString("description"));
                eventPOJOs.add(eventPOJO);
            }
            eventsActivity.processData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try{
            StringBuilder stringBuilder=new StringBuilder(NetworkDetails._URL+"GetEvents");
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

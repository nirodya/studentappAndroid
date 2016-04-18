package controller;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javainstitute.edu.lk.studentapp.Faq;
import javainstitute.edu.lk.studentapp.model.FaqPOJO;

/**
 * Created by Nirodya on 3/31/2016.
 */
public class CallFaqs extends AsyncTask {
    private String res;
    private ArrayList<FaqPOJO> faqPOJOs;
    private Faq faq;

    public CallFaqs(ArrayList<FaqPOJO> faqPOJOs, Faq faq) {
        this.faqPOJOs = faqPOJOs;
        this.faq = faq;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        try{
            JSONArray jsonArray=new JSONArray(res);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                FaqPOJO faqPOJO=new FaqPOJO(jsonObject.getString("question"),jsonObject.getString("answer"),jsonObject.getString("idquestion"));
                faqPOJOs.add(faqPOJO);
                faq.processData();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected Object doInBackground(Object[] params) {
        try{
            StringBuilder stringBuilder=new StringBuilder(NetworkDetails._URL+"GetQuestions");
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

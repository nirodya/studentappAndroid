package javainstitute.edu.lk.studentapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.charbgr.BlurNavigationDrawer.v7.BlurActionBarDrawerToggle;

import javainstitute.edu.lk.studentapp.model.Mark;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        BlurActionBarDrawerToggle toggle = new BlurActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setRadius(15);
        toggle.setDownScaleFactor(6.0f);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        linearLayout= (LinearLayout) findViewById(R.id.fragmentmaincontainer);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        News news=new News();
        fragmentTransaction.add(R.id.fragmentmaincontainer, news, "News");
        fragmentTransaction.commit();
    }

    /**
     * Checking for all possible internet providers
     * **/
    public boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Network[] networks = connectivityManager.getAllNetworks();
            NetworkInfo networkInfo;
            for (Network mNetwork : networks) {
                networkInfo = connectivityManager.getNetworkInfo(mNetwork);
                if (networkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                    return true;
                }
            }
        }else {
            if (connectivityManager != null) {
                //noinspection deprecation
                NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
                if (info != null) {
                    for (NetworkInfo anInfo : info) {
                        if (anInfo.getState() == NetworkInfo.State.CONNECTED) {
                            Log.d("Network",
                                    "NETWORKNAME: " + anInfo.getTypeName());
                            return true;
                        }
                    }
                }
            }
        }
        Snackbar snackbar = Snackbar
                .make(linearLayout, "Please Connect to Internet.", Snackbar.LENGTH_LONG);

        snackbar.show();
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        FragmentManager fragmentManager=getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.nav_news) {
            if (isConnectingToInternet()){
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                News news=new News();
                fragmentTransaction.add(R.id.fragmentmaincontainer,news,"News");
                fragmentTransaction.commit();
            }
        }else if (id == R.id.nav_syllabus) {
            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,Syllabus.class);
                startActivity(intent);
            }
        }else if (id == R.id.nav_events) {
            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,EventsActivity.class);
                startActivity(intent);
            }
        }else if (id == R.id.nav_complaints) {
            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,Complaint.class);
                startActivity(intent);
            }
        }else if (id==R.id.nav_history){
            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,History.class);
                startActivity(intent);
            }
        }else if (id==R.id.marks){
            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,Marks.class);
                startActivity(intent);
            }
        }else if (id==R.id.nav_contact){
            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,Contact.class);
                startActivity(intent);
            }
        }else if (id==R.id.letter){
//            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,LetterFormat.class);
                startActivity(intent);
//            }
        }else if (id==R.id.nav_faq){
//            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,Faq.class);
                startActivity(intent);
//            }
        }else if (id==R.id.nav_qualifications){
//            if (isConnectingToInternet()){
                Intent intent=new Intent(MainActivity.this,Qulifications.class);
                startActivity(intent);
//            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

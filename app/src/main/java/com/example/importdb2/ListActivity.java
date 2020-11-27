package com.example.importdb2;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private ActionBarDrawerToggle toggle;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;
    boolean doubleBackToExitPressedOnce = false;
    ListView listview;
//    number of rows to show
    int num =117;
//    data taken from sqlite using cursor
    String [] str=new String[num];
    String [] symbol=new String[num];
    String [] property=new String[num];
    String [] group=new String[num];
    String [] nature=new String[num];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_img);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        }

        TestAdapter mDbHelper = new TestAdapter(this);
        mDbHelper.createDatabase();
        mDbHelper.open();

        Cursor testdata = mDbHelper.getTestData();
        for (int i = 1; i <= num; i++) {
            str[i-1]=testdata.getString(1);
            testdata.moveToNext();
        }
        testdata.moveToFirst();
        for (int i = 1; i <= num; i++) {
            symbol[i-1]=testdata.getString(2);
            testdata.moveToNext();
        }
        testdata.moveToFirst();

        for (int i = 1; i <= num; i++) {
            property[i-1]=testdata.getString(4);
            testdata.moveToNext();
        }
        testdata.moveToFirst();

        for (int i = 1; i <= num; i++) {
            group[i-1]=testdata.getString(6);
            testdata.moveToNext();
        }
        testdata.moveToFirst();

        for (int i = 1; i <= num; i++) {
            nature[i-1]=testdata.getString(8);
            testdata.moveToNext();
        }
        int value =testdata.getCount();
        boolean doubleBackToExitPressedOnce = false;
        mDbHelper.close();

        ArrayList<Word> words = new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            String para1;
            String para2;
            String para3;
            String para4;
            String para5;

            if (str[i] != null ) para1=str[i].split(",")[0].substring(0, 1).toUpperCase() + str[i].split(",")[0].substring(1);
            else para1="N/A";
            if (symbol[i] != null ) para2=symbol[i].split(",")[0].substring(0, 1).toUpperCase() + symbol[i].split(",")[0].substring(1);
            else para2="N/A";
            if (property[i] != null ) para3=property[i].split(",")[0].substring(0, 1).toUpperCase() + property[i].split(",")[0].substring(1);
            else para3="N/A";
            if (group[i] != null ) para4=group[i].split(",")[0].substring(0, 1).toUpperCase() + group[i].split(",")[0].substring(1);
            else para4="N/A";
            if (nature[i] != null ) para5=nature[i].split(",")[0].substring(0, 1).toUpperCase() + nature[i].split(",")[0].substring(1);
            else para5="N/A";
            words.add(new Word(para1 , para2 , para3 , para4 , para5 )) ;
//            words.add(new Word(str[i],R.drawable.i60));
        }
        MyAdapter adapter = new MyAdapter(this,words);
        listview= findViewById(R.id.list_view);

        listview.setDivider(null);
        listview.setDividerHeight(0);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this,String.valueOf(position+1),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListActivity.this,DetailActivity.class);
                intent.putExtra("position",String.valueOf(position));
                startActivity(intent);
            }
        });

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav_view);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item1:
                        Toast.makeText(ListActivity.this, "About Us", Toast.LENGTH_SHORT).show();


                        return true;
                    case R.id.item2:
                        Toast.makeText(ListActivity.this, "Feedback", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent (Intent.ACTION_SEND);
                        intent.setType("message/rfc822");
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sm9080810@gmail.com"});
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback Of Periodic Table App");
                        intent.setPackage("com.google.android.gm");
                        intent.putExtra(Intent.EXTRA_TEXT, "Hello. This is a message sent from Periodic Table app :-)");

                        if (intent.resolveActivity(getPackageManager())!=null)
                            startActivity(intent);
                        else
                            Toast.makeText(ListActivity.this,"Gmail App is not installed",Toast.LENGTH_SHORT).show();

                        return true;

                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
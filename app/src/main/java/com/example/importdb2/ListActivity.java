package com.example.importdb2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        TestAdapter mDbHelper = new TestAdapter(this);
        mDbHelper.createDatabase();
        mDbHelper.open();
        Cursor testdata = mDbHelper.getTestData();
        int value =testdata.getCount();
        boolean doubleBackToExitPressedOnce = false;







        mDbHelper.close();

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
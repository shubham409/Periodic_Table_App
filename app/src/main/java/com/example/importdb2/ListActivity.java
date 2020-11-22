package com.example.importdb2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    ListView listview;
    String [] str=new String[60];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_img);

        TestAdapter mDbHelper = new TestAdapter(this);
        mDbHelper.createDatabase();
        mDbHelper.open();
        Cursor testdata = mDbHelper.getTestData();
        for (int i = 1; i <= 60; i++) {
            str[i-1]=testdata.getString(1).toString();
            testdata.moveToNext();
        }
        int value =testdata.getCount();
        boolean doubleBackToExitPressedOnce = false;
        mDbHelper.close();
        Integer img[]={
                R.drawable.i1, R.drawable.i2,  R.drawable.i3,
                R.drawable.i4, R.drawable.i5,  R.drawable.i6,
                R.drawable.i7, R.drawable.i8,  R.drawable.i9,
                R.drawable.i10,
                R.drawable.i11, R.drawable.i12,  R.drawable.i13,
                R.drawable.i14, R.drawable.i15,  R.drawable.i16,
                R.drawable.i17, R.drawable.i18,  R.drawable.i19,
                R.drawable.i20,
                R.drawable.i21, R.drawable.i22,  R.drawable.i23,
                R.drawable.i24, R.drawable.i25,  R.drawable.i26,
                R.drawable.i27, R.drawable.i28,  R.drawable.i29,
                R.drawable.i30,
                R.drawable.i31, R.drawable.i32,  R.drawable.i33,
                R.drawable.i34, R.drawable.i35,  R.drawable.i36,
                R.drawable.i37, R.drawable.i38,  R.drawable.i39,
                R.drawable.i40,
                R.drawable.i41, R.drawable.i42,  R.drawable.i43,
                R.drawable.i44, R.drawable.i45,  R.drawable.i46,
                R.drawable.i47, R.drawable.i48,  R.drawable.i49,
                R.drawable.i50,
                R.drawable.i51, R.drawable.i52,  R.drawable.i53,
                R.drawable.i54, R.drawable.i55,  R.drawable.i56,
                R.drawable.i57, R.drawable.i58,  R.drawable.i59,
                R.drawable.i60,
        };
        ArrayList<Word> words = new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            words.add(new Word(str[i],img[i]));
        }
        MyAdapter adapter = new MyAdapter(this,words);
        listview= findViewById(R.id.list_view);

        listview.setDivider(null);
        listview.setDividerHeight(0);

        listview.setAdapter(adapter);

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
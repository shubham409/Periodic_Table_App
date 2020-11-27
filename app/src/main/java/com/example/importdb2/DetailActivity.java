package com.example.importdb2;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class DetailActivity extends AppCompatActivity {
    int num;
    int at_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String position=getIntent().getStringExtra("position");
        at_index=Integer.parseInt(position);
        num=117;
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.black));
        }
        int []img=new int[num];
        for (int i = 0; i < num; i++) {
            int value;
            if (i>=104) value = i + 2;
            else value=i+1;
            img[i] =getResources().getIdentifier("com.example.importdb2:drawable/i"+value,null,null);
        }

        TestAdapter mDbHelper = new TestAdapter(this);
        mDbHelper.open();
        Cursor testdata = mDbHelper.getTestData();
        ImageView im = findViewById(R.id.image_view);
        im.setImageResource(img[at_index]);

        TextView name = findViewById(R.id.text_view1);
        testdata.moveToPosition(at_index);
        name.setText(testdata.getString(1));

        TextView col2 = findViewById(R.id.text_view2);
        testdata.moveToPosition(at_index);
        col2.setText(testdata.getString(2));

        TextView col3 = findViewById(R.id.text_view3);
        testdata.moveToPosition(at_index);
        col3.setText(testdata.getString(3));

        TextView col4 = findViewById(R.id.text_view4);
        testdata.moveToPosition(at_index);
        col4.setText(testdata.getString(4));

        TextView col5 = findViewById(R.id.text_view5);
        testdata.moveToPosition(at_index);
        col5.setText(testdata.getString(5));

        TextView col6 = findViewById(R.id.text_view6);
        testdata.moveToPosition(at_index);
        col6.setText(testdata.getString(6));

        TextView col7 = findViewById(R.id.text_view7);
        testdata.moveToPosition(at_index);
        col7.setText(testdata.getString(7));

        String na= "N/A";
        TextView col8 = findViewById(R.id.text_view8);
        testdata.moveToPosition(at_index);
        col8.setText(na);

        TextView col9 = findViewById(R.id.text_view9);
        testdata.moveToPosition(at_index);
        col9.setText(na);

        TextView col10 = findViewById(R.id.text_view10);
        testdata.moveToPosition(at_index);
        col10.setText(na);

        TextView col11 = findViewById(R.id.text_view11);
        testdata.moveToPosition(at_index);
        col11.setText(na);

        TextView col12 = findViewById(R.id.text_view12);
        testdata.moveToPosition(at_index);
        col12.setText(na);

        TextView col13 = findViewById(R.id.text_view13);
        testdata.moveToPosition(at_index);
        col13.setText(na);



    }
}
//
//        TextView tv= findViewById(R.id.test);
//        tv.setText(String.valueOf(position));


//        Integer []img={
//                R.drawable.i1, R.drawable.i2,  R.drawable.i3,
//                R.drawable.i4, R.drawable.i5,  R.drawable.i6,
//                R.drawable.i7, R.drawable.i8,  R.drawable.i9,
//                R.drawable.i10,
//                R.drawable.i11, R.drawable.i12,  R.drawable.i13,
//                R.drawable.i14, R.drawable.i15,  R.drawable.i16,
//                R.drawable.i17, R.drawable.i18,  R.drawable.i19,
//                R.drawable.i20,
//                R.drawable.i21, R.drawable.i22,  R.drawable.i23,
//                R.drawable.i24, R.drawable.i25,  R.drawable.i26,
//                R.drawable.i27, R.drawable.i28,  R.drawable.i29,
//                R.drawable.i30,
//                R.drawable.i31, R.drawable.i32,  R.drawable.i33,
//                R.drawable.i34, R.drawable.i35,  R.drawable.i36,
//                R.drawable.i37, R.drawable.i38,  R.drawable.i39,
//                R.drawable.i40,
//                R.drawable.i41, R.drawable.i42,  R.drawable.i43,
//                R.drawable.i44, R.drawable.i45,  R.drawable.i46,
//                R.drawable.i47, R.drawable.i48,  R.drawable.i49,
//                R.drawable.i50,
//                R.drawable.i51, R.drawable.i52,  R.drawable.i53,
//                R.drawable.i54, R.drawable.i55,  R.drawable.i56,
//                R.drawable.i57, R.drawable.i58,  R.drawable.i59,
//                R.drawable.i60,
//        };
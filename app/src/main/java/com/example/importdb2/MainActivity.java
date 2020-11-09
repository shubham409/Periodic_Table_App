package com.example.importdb2;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timer = new Thread(){
            @Override
            public void run(){
                try {
                    sleep(5000);
                    Intent intent = new Intent(getBaseContext(),ListActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();

    }
    public void changeActivity()
    {
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }
}
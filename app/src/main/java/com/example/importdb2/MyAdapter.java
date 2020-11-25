package com.example.importdb2;

//import android.app.Activity;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.ArrayList;
//public class MyAdapter extends ArrayAdapter<Word> {
//    MyAdapter(Activity context, ArrayList<Word>word)
//    {
//        super(context,0,word);
//    }
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        View itemview=convertView;
//        if (itemview == null) {
//            itemview = LayoutInflater.from(getContext()).inflate(R.layout.one_row, parent, false);
//        }
//        Word currentword = getItem(position);
//        TextView textview =itemview.findViewById(R.id.text_view);
//        textview.setText(currentword.getName());
//        ImageView imageview=itemview.findViewById(R.id.image_view);
//        imageview.setImageResource(currentword.getResourceid());
//        return itemview;
//    }
//}

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
public class MyAdapter extends ArrayAdapter<Word> {
    MyAdapter(Activity context, ArrayList<Word>word)
    {
        super(context,0,word);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemview=convertView;
        if (itemview == null) {
            itemview = LayoutInflater.from(getContext()).inflate(R.layout.one_row, parent, false);
        }
        Word currentword = getItem(position);
        TextView textview1 =itemview.findViewById(R.id.symbol);
        textview1.setText(currentword.getSymbol());
        TextView textview2 =itemview.findViewById(R.id.name);
        textview2.setText(currentword.getName());
        TextView textview3 =itemview.findViewById(R.id.property);
        textview3.setText(currentword.getProperty());
        TextView textview4 =itemview.findViewById(R.id.group);
        textview4.setText(currentword.getGroup());
        TextView textview5 =itemview.findViewById(R.id.nature);
        textview5.setText(currentword.getNature());
//        ImageView imageview=itemview.findViewById(R.id.image_view);
//        imageview.setImageResource(currentword.getResourceid());
        return itemview;
    }
}


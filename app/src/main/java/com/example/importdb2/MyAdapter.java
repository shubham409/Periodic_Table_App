package com.example.importdb2;

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
        TextView textview =itemview.findViewById(R.id.text_view);
        textview.setText(currentword.getName());
        ImageView imageview=itemview.findViewById(R.id.image_view);
        imageview.setImageResource(currentword.getResourceid());

        return itemview;



    }



}

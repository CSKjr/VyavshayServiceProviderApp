package com.example.vyavshayserviceproviderapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.pojo.ItemGrid;

import java.util.ArrayList;

public class MyGridAdapter extends ArrayAdapter {
    ArrayList birdList = new ArrayList<>();

    public MyGridAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);
        birdList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        ItemGrid itemGrid = (ItemGrid) getItem(position);

//        View v = convertView;
//        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        v = inflater.inflate(R.layout.grid_view_items, null);

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_view_items, parent, false);
        }

        ItemGrid itemGrid = (ItemGrid) getItem(position);
        TextView textView = (TextView) listitemView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) listitemView.findViewById(R.id.imageView);
        textView.setText(itemGrid.getBirdListName());
        imageView.setImageResource(itemGrid.getBirdListImage());
        return listitemView;

    }
}


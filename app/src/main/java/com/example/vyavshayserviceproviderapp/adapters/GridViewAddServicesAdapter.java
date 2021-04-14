package com.example.vyavshayserviceproviderapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.pojo.AppResourceModel;

import java.util.List;

public class GridViewAddServicesAdapter extends BaseAdapter {

    private AppResourceModel appResourceModel = new AppResourceModel();

    List<AppResourceModel.AllResource> allResources = appResourceModel.getMlist();

    private Context mContext;

    // Constructor
    public GridViewAddServicesAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return allResources.size();
    }

    @Override
    public Object getItem(int position) {
        return allResources.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 2
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.add_services_gridview, null);
        }
        // 3
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.addNewServicesimageview);
        final TextView nameTextView = (TextView) convertView.findViewById(R.id.addNewServicestextview);
        // textView.setLayoutParams(new GridLayout.LayoutParams(10, 10));
        imageView.setImageResource(allResources.get(position).getInteger());
        nameTextView.setText(allResources.get(position).getString());
        return convertView;
    }
}

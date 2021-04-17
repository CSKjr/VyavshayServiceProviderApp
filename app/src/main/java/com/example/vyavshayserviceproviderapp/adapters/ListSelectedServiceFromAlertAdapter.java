package com.example.vyavshayserviceproviderapp.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.pojo.AppResourceModel;

import java.util.List;

public class ListSelectedServiceFromAlertAdapter extends RecyclerView.Adapter<ListSelectedServiceFromAlertAdapter.MyViewHolder> {
    public ListSelectedServiceFromAlertAdapter(List<AppResourceModel.AllResource> allResources) {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View view) {
            super(view);


        }
    }
}

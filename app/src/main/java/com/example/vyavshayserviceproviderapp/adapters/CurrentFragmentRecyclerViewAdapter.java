package com.example.vyavshayserviceproviderapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vyavshayserviceproviderapp.R;

public class CurrentFragmentRecyclerViewAdapter extends RecyclerView.Adapter<CurrentFragmentRecyclerViewAdapter.MyListViewHolder> {
    @NonNull
    @Override
    public MyListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_current_list_items, parent, false);

        return new MyListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyListViewHolder holder, int position) {

        holder.date.setText("05 April 2021");
        holder.orderNo.setText("123456789");
        holder.time.setText("9:00 AM - 12:00pm");
        holder.price.setText("476");
    }

    @Override
    public int getItemCount() {
        return 4;
    }


    public static class MyListViewHolder extends RecyclerView.ViewHolder {
        public TextView date, time, orderNo, price;

        public MyListViewHolder(View view) {
            super(view);
            orderNo = (TextView) view.findViewById(R.id.eventlistOrderNo);
            date = (TextView) view.findViewById(R.id.eventlistDate);
            time = (TextView) view.findViewById(R.id.eventlistTime);
            price = (TextView) view.findViewById(R.id.eventlistPrice);

        }
    }
}

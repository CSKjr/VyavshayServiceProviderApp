package com.example.vyavshayserviceproviderapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.pojo.TestPojo;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MovieVH> {
//    private final int[] picslist;
//
//    public RecyclerViewAdapter(int[] imageList) {
//
//        this.picslist = imageList;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_service_details, parent, false);
//
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.imageView.setImageResource(picslist[position]);
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return picslist.length;
//    }
//
//    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        public ImageView imageView;
//
//        public MyViewHolder(View view) {
//            super(view);
//            imageView = (ImageView) view.findViewById(R.id.recyclerviewitem);
//
//        }
//    }


    List<TestPojo> movieList;

    public RecyclerViewAdapter(List<TestPojo> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_layout, parent, false);
        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {

        TestPojo movie = movieList.get(position);
//        holder.titleTextView.setText(movie.getTitle());
//        holder.yearTextView.setText(movie.getYear());
//        holder.ratingTextView.setText(movie.getRating());
//        holder.plotTextView.setText(movie.getPlot());

        boolean isExpanded = movie.isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieVH";

        RelativeLayout expandableLayout;
        TextView titleTextView, yearTextView, ratingTextView, plotTextView;

        public MovieVH(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
//            yearTextView = itemView.findViewById(R.id.yearTextView);
//            ratingTextView = itemView.findViewById(R.id.ratingTextView);
//            plotTextView = itemView.findViewById(R.id.plotTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);


            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    TestPojo movie = movieList.get(getAdapterPosition());
                    movie.setExpanded(!movie.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}

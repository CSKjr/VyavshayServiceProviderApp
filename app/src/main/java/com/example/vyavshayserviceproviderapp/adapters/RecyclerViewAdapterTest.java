package com.example.vyavshayserviceproviderapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.pojo.AppResourceModel;
import com.example.vyavshayserviceproviderapp.pojo.TestPojo;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapterTest extends RecyclerView.Adapter<RecyclerViewAdapterTest.MovieVH> {

//    List<TestPojo> movieList;

    private List<AppResourceModel.AllResource> mlist;


//    private AppResourceModel appResourceModel = new AppResourceModel();
//    List<AppResourceModel.AllResource> allResources = appResourceModel.getMlist();

    public RecyclerViewAdapterTest(List<AppResourceModel.AllResource> mlist) {
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_layout, parent, false);
        return new MovieVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {

//        AppResourceModel.AllResource movie = allResources.get(position);
//        holder.titleTextView.setText(movie.getTitle());
//        holder.yearTextView.setText(movie.getYear());
//        holder.ratingTextView.setText(movie.getRating());
//        holder.plotTextView.setText(movie.getPlot());

        List<AppResourceModel.AllResource> nlist = new ArrayList<>();
        nlist.clear();
        for (AppResourceModel.AllResource list : mlist) {
            if (list.isItemselected()) {
                nlist.add(list);
            }
        }

            boolean isExpanded = nlist.get(position).isExpanded();
            holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {

        int a = 0;
        for (AppResourceModel.AllResource list : mlist) {
            if (list.isItemselected()) {
                a++;
            }


        }
        return a;
//        return movieList.size();
    }

    class MovieVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieVH";

        RelativeLayout expandableLayout;
        //        TextView titleTextView, yearTextView, ratingTextView, plotTextView;
        LinearLayout titleTextView;

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

                    AppResourceModel.AllResource movie = mlist.get(getAdapterPosition());
                    movie.setExpanded(!movie.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}

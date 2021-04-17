package com.example.vyavshayserviceproviderapp.pojo;

import android.widget.LinearLayout;


import com.example.vyavshayserviceproviderapp.R;

import java.util.ArrayList;
import java.util.List;

public class AppResourceModel {

    private List<AllResource> mlist = new ArrayList<>();


    public List<AllResource> getMlist() {

        mlist.add(new AllResource(R.drawable.ic_tractor, "Tractor", 1, false));
        mlist.add(new AllResource(R.drawable.ic_cultivator_icon, "Cultivatior", 1, false));
        mlist.add(new AllResource(R.drawable.ic_land_leveler, "Land Leveler", 1, false));
        mlist.add(new AllResource(R.drawable.ic_mould_board, "Mould Board Plough", 1, false));
        mlist.add(new AllResource(R.drawable.ic_multi_crop, "Multi Crop Power Thresher", 1, false));
        mlist.add(new AllResource(R.drawable.ic_operator, "Operator", 1, false));
        mlist.add(new AllResource(R.drawable.ic_seed_drill, "Seed Drill", 1, false));
        mlist.add(new AllResource(R.drawable.ic_self_propelled, "Self Propelled Reaper", 1, false));
        mlist.add(new AllResource(R.drawable.ic_trailor, "Trailor", 1, false));
        mlist.add(new AllResource(R.drawable.ic_utility_icon, "Disc Harrow", 1, false));


        return mlist;
    }


    public class AllResource {

        private int a,count;
        private String vehiclename, date, measurementType, rentalHours, startDate, endDate, startTime, endTime, typeDailyOrHourly;
        private boolean itemselected;
        private boolean expanded;


        public AllResource(int integer, String string, int count, boolean itemselected) {
            this.a = integer;
            this.vehiclename = string;
            this.count = count;
            this.itemselected = itemselected;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getInteger() {
            return a;
        }

        public String getString() {
            return vehiclename;
        }

        public int getCount() {
            return count;
        }

        public void addCount() {
            this.count += 1;
        }

        public void subCount() {
            if (getCount() == 0) {
                this.count = 0;
            } else {
                this.count -= 1;
            }

        }

        public void setItemselected(boolean itemselected) {
            this.itemselected = itemselected;
        }

        public boolean isItemselected() {
            return itemselected;
        }

        public boolean isExpanded() {
            return expanded;
        }

        public void setExpanded(boolean expanded) {
            this.expanded = expanded;
        }

    }
}

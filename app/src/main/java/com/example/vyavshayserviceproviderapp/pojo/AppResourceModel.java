package com.example.vyavshayserviceproviderapp.pojo;

import android.widget.LinearLayout;


import com.example.vyavshayserviceproviderapp.R;

import java.util.ArrayList;
import java.util.List;

public class AppResourceModel {

    private List<AllResource> mlist = new ArrayList<>();


    public List<AllResource> getMlist() {
        mlist.add(new AllResource(R.drawable.ic_tractor, "Tractor"));
        mlist.add(new AllResource(R.drawable.ic_cultivator_icon, "Cultivatior"));
        mlist.add(new AllResource(R.drawable.ic_land_leveler, "Land Leveler"));
        mlist.add(new AllResource(R.drawable.ic_mould_board, "Mould Board Plough"));
        mlist.add(new AllResource(R.drawable.ic_multi_crop, "Multi Crop Power Thresher"));
        mlist.add(new AllResource(R.drawable.ic_operator, "Operator"));
        mlist.add(new AllResource(R.drawable.ic_seed_drill, "Seed Drill"));
        mlist.add(new AllResource(R.drawable.ic_self_propelled, "Self Propelled Reaper"));
        mlist.add(new AllResource(R.drawable.ic_trailor, "Trailor"));
        mlist.add(new AllResource(R.drawable.ic_utility_icon, "Disc Harrow"));


        return mlist;
    }


    public class AllResource {

        private Integer integer;
        private String string;

        public AllResource(Integer integer, String string) {
            this.integer = integer;
            this.string = string;
        }


        public Integer getInteger() {
            return integer;
        }

        public String getString() {
            return string;
        }
    }
}

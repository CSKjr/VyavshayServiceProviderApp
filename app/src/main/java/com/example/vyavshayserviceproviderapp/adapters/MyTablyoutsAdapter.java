package com.example.vyavshayserviceproviderapp.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.vyavshayserviceproviderapp.activities.DashBoardServiceProvider;
import com.example.vyavshayserviceproviderapp.fragments.CompletedFragment;
import com.example.vyavshayserviceproviderapp.fragments.CurrentFragment;
import com.example.vyavshayserviceproviderapp.fragments.UpComingFragment;

public class MyTablyoutsAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyTablyoutsAdapter(Context context, FragmentManager supportFragmentManager, int totalTabs) {
        super(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CurrentFragment currentFragment = new CurrentFragment();
                return currentFragment;
            case 1:
                UpComingFragment upComingFragment = new UpComingFragment();
                return upComingFragment;
            case 2:
                CompletedFragment completedFragment = new CompletedFragment();
                return completedFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

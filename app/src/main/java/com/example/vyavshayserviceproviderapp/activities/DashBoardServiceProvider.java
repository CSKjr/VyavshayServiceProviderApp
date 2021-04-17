package com.example.vyavshayserviceproviderapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.adapters.MyTablyoutsAdapter;
import com.google.android.material.tabs.TabLayout;

public class DashBoardServiceProvider extends AppCompatActivity {

    private ImageView selectService;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board_service_provider);

//        getActionBar().setTitle("Hello world App");
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.appbarlayout_tool_bar);
//        toolbar.setTitle("This is toolbar.");
//        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
//            Calendar cal = Calendar.getInstance();
//            String dynamicTitle = cal.getTime().toString();
            //Setting a dynamic title at runtime. Here, it displays the current time.
            actionBar.setTitle("dynamicTitle");
        }

        selectService = (ImageView) findViewById(R.id.selectServiceImage);


        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);

        selectService.setOnClickListener(clicked);

        tabLoyoutFunctionalities();

    }

    public void tabLoyoutFunctionalities() {
        final MyTablyoutsAdapter adapter = new MyTablyoutsAdapter(this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private View.OnClickListener clicked = v -> {
//            switch(v.getId()){
//                case R.id.selectServiceImage:
                Intent i = new Intent(DashBoardServiceProvider.this, EquipmentDetails.class);
                startActivity(i);
//                    break;
//            }
    };



}
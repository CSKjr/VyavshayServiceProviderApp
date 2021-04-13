package com.example.vyavshayserviceproviderapp.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;

import com.example.vyavshayserviceproviderapp.R;

public class DashBoardServiceProvider extends AppCompatActivity {

    private ImageView selectService;
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

        selectService.setOnClickListener(clicked);

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
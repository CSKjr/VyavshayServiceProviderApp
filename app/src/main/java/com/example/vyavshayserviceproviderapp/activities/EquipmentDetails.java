package com.example.vyavshayserviceproviderapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.adapters.GridViewAddServicesAdapter;
import com.example.vyavshayserviceproviderapp.adapters.MyGridAdapter;
import com.example.vyavshayserviceproviderapp.pojo.AddServiceModel;
import com.example.vyavshayserviceproviderapp.pojo.AppResourceModel;
import com.example.vyavshayserviceproviderapp.pojo.ItemGrid;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EquipmentDetails extends AppCompatActivity {

    int minteger = 0;
    CalendarView calendarView;
    private Button addMoreBtn;
    private TextView eReminderTime;

    List<String> list = new ArrayList<String>();
    private RecyclerView recyclerViewSelectedItems;
    // add services selected equipments
    List<Integer> selectItems = new ArrayList<>();

    // private int[] imagelist = new int[15];
    List<Integer> imagelist = new ArrayList<Integer>();
    List<AddServiceModel> addServiceModels = new ArrayList<>();
    //
    private AppResourceModel appResourceModel = new AppResourceModel();
    List<AppResourceModel.AllResource> allResources = appResourceModel.getMlist();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_details);

        calendarView = (CalendarView)
                findViewById(R.id.calender);
        addMoreBtn = (Button) findViewById(R.id.addMoreBtn);
        eReminderTime = (TextView) findViewById(R.id.displayTime);

//        ActionBar actionBar = getSupportActionBar();
//        // showing the back button in action bar
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.appbarlayout_tool_bar);
//        toolbar.setTitle("Add Services");
//        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
//            Calendar cal = Calendar.getInstance();
//            String dynamicTitle = cal.getTime().toString();
            //Setting a dynamic title at runtime. Here, it displays the current time.
            actionBar.setTitle("Add Services");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String[] type = new String[] {"Tractor", "Pumpser", "Tractor Driver"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        R.layout.dropdown_menu_popup_item,
                        type);

        AutoCompleteTextView editTextFilledExposedDropdown =
                findViewById(R.id.autoComplete);
        editTextFilledExposedDropdown.setAdapter(adapter);

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(arrayAdapter);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                if (parent.getItemAtPosition(position).equals("Select Equipment")){
//
//                }else {
//                    String item = parent.getItemAtPosition(position).toString();
//                    Toast.makeText(parent.getContext(),"Selected: " +item, Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

        initViews();
    }

    private void initViews() {

        addMoreBtn.setOnClickListener(clicked);
    }

    private View.OnClickListener clicked = v -> {
        if(v.getId() == R.id.addMoreBtn) {
            openServicesDialog();


//            ImageButton facebook_button = (ImageButton)promptView.findViewById(R.id.imgFirst);


            Toast.makeText(getApplicationContext(),"Save is clicked",Toast.LENGTH_LONG).show();

        }
       else if(v.getId() == R.id.saveBtn)
              {
//                  Calendar mcurrentTime = Calendar.getInstance();
//                  int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//                  int minute = mcurrentTime.get(Calendar.MINUTE);
//                  TimePickerDialog mTimePicker;
//                  mTimePicker = new TimePickerDialog(EquipmentDetails.this, new TimePickerDialog.OnTimeSetListener() {
//                      @Override
//                      public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                          eReminderTime.setText( selectedHour + ":" + selectedMinute);
//                      }
//                  }, hour, minute, true);//Yes 24 hour time
//                  mTimePicker.setTitle("Select Time");
//                  mTimePicker.show();
                  Toast.makeText(getApplicationContext(),"Save is clicked",Toast.LENGTH_LONG).show();

              }
    };

    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }
    public void decreaseInteger(View view) {
//        double value = Double.parseDouble(String.valueOf(minteger));
//        if(value>0) {
        if(minteger>0)
        {
            minteger = minteger - 1;
            display(minteger);
        }
    }

    private void display(int number) {
//        TextView displayInteger = (TextView) findViewById(
//                R.id.integer_number);
//        displayInteger.setText("" + number);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openServicesDialog() {
        GridView gridView = new GridView(getApplicationContext());

        List<Integer> mList = new ArrayList<Integer>();
        for (int i = 1; i < 106; i++) {
            mList.add(i);
        }

        //gridView.setAdapter(new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, mThumbIds));
        gridView.setAdapter(new GridViewAddServicesAdapter(getApplicationContext()));
        gridView.setNumColumns(3);
        gridView.setVerticalSpacing(30);
        gridView.setHorizontalSpacing(20);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // do something here
                ImageView imageView = view.findViewById(R.id.addNewServicesimageview);
                ImageView tickmark = view.findViewById(R.id.addNewServicesTickMark);
                RelativeLayout relativeLayout = view.findViewById(R.id.addNewServiceslinearlayout);

                if (!selectItems.contains(position)) {
                    // new item has been selected
                    selectItems.add(position);
                    tickmark.setVisibility(View.VISIBLE);
                    relativeLayout.setBackground(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.square_outline_green));
                    // add image and its name to list<model>

                    addServiceModels.add(new AddServiceModel(allResources.get(position).getInteger(), allResources.get(position).getString(), 1));
                } else {
                    // un selecting the item

                    selectItems.remove(Integer.valueOf(position));
                    tickmark.setVisibility(View.INVISIBLE);
                    if (addServiceModels.contains(new AddServiceModel(allResources.get(position).getInteger(), allResources.get(position).getString(), 1))) {
                        addServiceModels.remove(new AddServiceModel(allResources.get(position).getInteger(), allResources.get(position).getString(), 1));
                    }

                    relativeLayout.setBackground(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.square_outline_grey));
                    // imageView.setImageResource(android.R.color.transparent);
                }


            }
        });

        // Set grid view to alertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(gridView);
        builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent i = new Intent(EquipmentDetails.this, ListSelectedServiceFromAlert.class);
                startActivity(i);
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setTitle("Add Services");
        builder.show();
    }

}
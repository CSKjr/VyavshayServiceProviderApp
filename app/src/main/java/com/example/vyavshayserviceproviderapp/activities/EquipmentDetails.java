package com.example.vyavshayserviceproviderapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.TimePickerDialog;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.adapters.MyGridAdapter;
import com.example.vyavshayserviceproviderapp.pojo.ItemGrid;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class EquipmentDetails extends AppCompatActivity {

    int minteger = 0;
    CalendarView calendarView;
    private Button addMoreBtn;
    private TextView eReminderTime;
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

//                    // Create custom dialog object
//                    final Dialog dialog = new Dialog(EquipmentDetails.this);
//                    // Include dialog.xml file
//                    dialog.setContentView(R.layout.dialog);
//                    // Set dialog title
//                    dialog.setTitle("Custom Dialog");
//
//                    // set values for custom dialog components - text, image and button
//                    TextView text = (TextView) dialog.findViewById(R.id.textDialog);
//                    text.setText("Custom dialog Android example.");
//                    ImageView image = (ImageView) dialog.findViewById(R.id.imageDialog);
//                    image.setImageResource(R.drawable.image0);

//                    dialog.show();

//            Calendar mcurrentTime = Calendar.getInstance();
//            int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
//            int minute = mcurrentTime.get(Calendar.MINUTE);
//            TimePickerDialog mTimePicker;
//            mTimePicker = new TimePickerDialog(EquipmentDetails.this, new TimePickerDialog.OnTimeSetListener() {
//                @Override
//                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                    eReminderTime.setText( selectedHour + ":" + selectedMinute);
//                }
//            }, hour, minute, true);//Yes 24 hour time
//            mTimePicker.setTitle("Select Time");
//            mTimePicker.show();
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            View promptView = layoutInflater.inflate(R.layout.alert_dialogue, null);
            final AlertDialog.Builder alertD = new AlertDialog.Builder(this);
            alertD.setTitle("SELECT SERVICE CATEGORY");
            alertD.setView(promptView);
            alertD.show();

            ArrayList birdList=new ArrayList<>();
            GridView simpleList = (GridView) promptView.findViewById(R.id.simpleGridView);
            birdList.add(new ItemGrid("Bird 1",R.drawable.ic_add_photo));
            birdList.add(new ItemGrid("Bird 2",R.drawable.ic_add_photo));
            birdList.add(new ItemGrid("Bird 3",R.drawable.ic_add_photo));
            birdList.add(new ItemGrid("Bird 4",R.drawable.ic_add_photo));
            birdList.add(new ItemGrid("Bird 5",R.drawable.ic_add_photo));
            birdList.add(new ItemGrid("Bird 6",R.drawable.ic_add_photo));


            MyGridAdapter myAdapter=new MyGridAdapter(this,R.layout.grid_view_items,birdList);
            simpleList.setAdapter(myAdapter);


//            ImageButton facebook_button = (ImageButton)promptView.findViewById(R.id.imgFirst);
//            ImageButton twitter_button = (ImageButton)promptView.findViewById(R.id.imgSecond);
//            ImageButton intagram_button = (ImageButton)promptView.findViewById(R.id.instagram_share_button);
//            ImageButton messanger_button = (ImageButton)promptView.findViewById(R.id.messanger_share_button);
//            ImageButton viber_button = (ImageButton)promptView.findViewById(R.id.viber_share_button);
//            ImageButton whatsapp_button = (ImageButton)promptView.findViewById(R.id.whatsapp_share_button);

//            facebook_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            twitter_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    shareTwitter(v, bitmap);//just a sample of what I want to do
//                }
//            });
//            intagram_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            messanger_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            viber_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//            whatsapp_button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });


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
}
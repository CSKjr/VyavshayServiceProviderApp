package com.example.vyavshayserviceproviderapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.audiofx.DynamicsProcessing;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.vyavshayserviceproviderapp.R;
import com.example.vyavshayserviceproviderapp.adapters.GridViewAddServicesAdapter;
import com.example.vyavshayserviceproviderapp.adapters.ListSelectedServiceFromAlertAdapter;
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
    private ImageView uploadIDProof;

    private ImageView selectionimageView;
    private Boolean isClicked = false;
    private ListSelectedServiceFromAlertAdapter recyclerViewAdapter;


    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "SelectImageActivity";

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
        uploadIDProof = (ImageView) findViewById(R.id.selectIDProof);

//        ActionBar actionBar = getSupportActionBar();
//        // showing the back button in action bar
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.appbarlayout_tool_bar);
//        toolbar.setTitle("Add Services");
//        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
//            Calendar cal = Calendar.getInstance();
//            String dynamicTitle = cal.getTime().toString();
            //Setting a dynamic title at runtime. Here, it displays the current time.
            actionBar.setTitle("Add Services");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String[] type = new String[]{"Tractor", "Pumpser", "Tractor Driver"};

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


        handlePermission();
    }

    private void initViews() {

        addMoreBtn.setOnClickListener(clicked);

        uploadIDProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImageChooser();
            }
        });
    }

    private View.OnClickListener clicked = v -> {
        if (v.getId() == R.id.addMoreBtn) {
            openServicesDialog();


//            ImageButton facebook_button = (ImageButton)promptView.findViewById(R.id.imgFirst);


            Toast.makeText(getApplicationContext(), "Save is clicked", Toast.LENGTH_LONG).show();

        } else if (v.getId() == R.id.saveBtn) {
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
            Toast.makeText(getApplicationContext(), "Save is clicked", Toast.LENGTH_LONG).show();

        }
    };

    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);

    }

    public void decreaseInteger(View view) {
//        double value = Double.parseDouble(String.valueOf(minteger));
//        if(value>0) {
        if (minteger > 0) {
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
                selectionimageView = view.findViewById(R.id.addNewServicesimageview);
                Toast.makeText(view.getContext(), "Position is " + position, Toast.LENGTH_LONG).show();

//                AlertDialog dialog = alertbox.create();
//
//                Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);


                //
                if (!allResources.get(position).isItemselected()) {
                    // new item has been selected
                    isClicked = true;

                    selectionimageView.setBackground(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.square_outline_green));
                    // add image and its name to list<model>
                    allResources.get(position).setItemselected(true);
                    allResources.notifyAll();

                } else {
                    // un selecting the item

                    // ui change
                    isClicked = false;

                    selectionimageView.setBackground(AppCompatResources.getDrawable(getApplicationContext(), R.drawable.square_outline_grey));
                    allResources.get(position).setItemselected(false);

                }
            }
        });

        // Set grid view to alertDialog

        final AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("SELECT SERVICE CATAGORY")
                .setView(gridView)
                .setPositiveButton("Ok", null)
                .setNegativeButton("Cancel", null)
                .show();

        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
//                    AppResourceModel.AllResource dene = new AppResourceModel.AllResource(4,"Mustafa", 0,false);
                    Intent i = new Intent(EquipmentDetails.this, ListSelectedServiceFromAlert.class);
//                    i.putExtra("sampleObject", dene);
                    startActivity(i);
                    dialog.dismiss();
                } else
                {
                    Toast.makeText(getApplicationContext(), "Select Something", Toast.LENGTH_LONG).show();

                }
            }
        });

//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setView(gridView);
//        builder.setCancelable(false);
//
//        builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
////                GridViewAddServicesAdapter gridViewAddServicesAdapter = new GridViewAddServicesAdapter(getApplicationContext());
////                gridViewAddServicesAdapter.notifyDataSetChanged();
//
////                ListView lw = ((AlertDialog)dialog).getListView();
//////                Object checkedItem = lw.getAdapter().getItem(lw.getCheckedItemPosition());
////                if(lw.getCheckedItemCount() > 0) {
//                if (isClicked) {
//                    Intent i = new Intent(EquipmentDetails.this, ListSelectedServiceFromAlert.class);
//                    startActivity(i);
//                } else
//                    {
//                    Toast.makeText(getApplicationContext(), "Select Something", Toast.LENGTH_LONG).show();
//
//                    }
//            }
//        });
//        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//        builder.setTitle("Add Services");
//        builder.show();
    }

    private void handlePermission() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //ask for permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    SELECT_PICTURE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case SELECT_PICTURE:
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(this, permission);
                        if (showRationale) {
                            //  Show your own message here
                        } else {
                            showSettingsAlert();
                        }
                    }
                }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /* Choose an image from Gallery */
    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (resultCode == RESULT_OK) {
                    if (requestCode == SELECT_PICTURE) {
                        // Get the url from data
                        final Uri selectedImageUri = data.getData();
                        if (null != selectedImageUri) {
                            // Get the path from the Uri
                            String path = getPathFromURI(selectedImageUri);
                            Log.i(TAG, "Image Path : " + path);
                            // Set the image in ImageView
                            findViewById(R.id.displayProof).post(new Runnable() {
                                @Override
                                public void run() {
                                    findViewById(R.id.displayProof).setVisibility(View.VISIBLE);
                                    ((ImageView) findViewById(R.id.displayProof)).setImageURI(selectedImageUri);
                                }
                            });

                        }
                    }
                }
            }
        }).start();

    }

    /* Get the real path from the URI */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }


    private void showSettingsAlert() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("App needs to access the Camera.");
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "DONT ALLOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        //finish();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SETTINGS",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        openAppSettings(EquipmentDetails.this);
                    }
                });
        alertDialog.show();
    }

    public static void openAppSettings(final Activity context) {
        if (context == null) {
            return;
        }
        final Intent i = new Intent();
        i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        i.addCategory(Intent.CATEGORY_DEFAULT);
        i.setData(Uri.parse("package:" + context.getPackageName()));
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        i.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(i);
    }


}
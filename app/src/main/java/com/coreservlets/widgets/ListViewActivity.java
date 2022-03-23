package com.coreservlets.widgets;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ListViewActivity  extends Activity implements OnItemClickListener {
    private String mPlantillaMensajeItemSelected;
    ListView lv;
    ArrayAdapter<String> listAdapter;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.listview);
                mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview);
        lv = findViewById(R.id.listview);

        List<String> futureAndroidVendors = getFutureAndroidVendors();
        listAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, futureAndroidVendors);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(this);
        registerForContextMenu(lv);
        
    }
    
    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = { "RIM", "Palm", "Nokia"};
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }
    
    
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
    
    
    public void onItemClick(AdapterView<?> listv, View selectedView,
                                   int position, long id) {
                String selection = listv.getItemAtPosition(position).toString();
                String message =
                        String.format(mPlantillaMensajeItemSelected, selection);
                showToast(message);
    }
}
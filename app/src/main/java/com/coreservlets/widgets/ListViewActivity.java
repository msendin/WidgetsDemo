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

import com.coreservlets.widgets.databinding.ListviewBinding;
import com.coreservlets.widgets.databinding.SpinnersBinding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ListViewActivity  extends Activity implements OnItemClickListener {
    private String mPlantillaMensajeItemSelected;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListviewBinding binding = ListviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview);

        List<String> futureAndroidVendors = getFutureAndroidVendors();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, futureAndroidVendors);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setOnItemClickListener(this);
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
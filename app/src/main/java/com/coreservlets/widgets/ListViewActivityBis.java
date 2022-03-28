package com.coreservlets.widgets;

import android.app.ListActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListViewActivityBis extends ListActivity {
    private String mPlantillaMensajeItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview);
        List<String> futureAndroidVendors = getFutureAndroidVendors();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, futureAndroidVendors);

        setListAdapter(listAdapter);
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


    public void onListItemClick(ListView listv, View selectedView,
                                int position, long id) {
        String selection = getListAdapter().getItem(position).toString();
        String message =
                String.format(mPlantillaMensajeItemSelected, selection);
        showToast(message);
    }
}
package com.development.tylerwindham.liscensescanner;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.development.tylerwindham.licenseObjects.AdditionalDrivers;
import com.development.tylerwindham.licenseObjects.Driver;

public class DriverActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);
        ListView listView = getListView();

    }

    public void onGoQuotePage(View view){
        
    }
}

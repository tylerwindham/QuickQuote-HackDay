package com.development.tylerwindham.liscensescanner;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.development.tylerwindham.licenseObjects.AdditionalDrivers;
import com.development.tylerwindham.licenseObjects.Driver;
import com.development.tylerwindham.licenseObjects.PersonalInfo;

public class DriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        Intent intent = getIntent();
        PersonalInfo personalInfo = (PersonalInfo)intent.getParcelableExtra(PersonalInfo.PERSONAL_INFO);

//        EditText etxtFirstName = (EditText) findViewById(R.id.etxtFirstName);
//        etxtFirstName.setText(personalInfo.getFirstName());
//        EditText etxtMiddleName = (EditText) findViewById(R.id.etxtMiddleName);
//        etxtMiddleName.setText(personalInfo.getMiddleInitial());
//        EditText etxtLastName = (EditText) findViewById(R.id.etxtLastName);
//        etxtLastName.setText(personalInfo.getLastName());
//        EditText etxtAccidentApplicant = (EditText) findViewById(R.id.etxtAccidentApplicant);

        AdditionalDrivers drivers = new AdditionalDrivers();
        EditText etxtFirstName2 = (EditText) findViewById(R.id.etxtFirstName2);
        etxtFirstName2.setText(drivers.getDrivers().get(0).getFirstName());
        EditText etxtMiddleName2 = (EditText) findViewById(R.id.etxtMiddleName2);
        etxtMiddleName2.setText("");
        EditText etxtLastName2 = (EditText) findViewById(R.id.etxtLastName2);
        etxtLastName2.setText(drivers.getDrivers().get(0).getLastName());
        EditText etxtAccidentDriver1 = (EditText) findViewById(R.id.etxtAccidentDriver1);
        etxtAccidentDriver1.setText(drivers.getDrivers().get(0).getAccident().getDescription());

        EditText etxtFirstName3 = (EditText) findViewById(R.id.etxtFirstName3);
        etxtFirstName3.setText(drivers.getDrivers().get(1).getFirstName());
        EditText etxtMiddleName3 = (EditText) findViewById(R.id.etxtMiddleName3);
        etxtMiddleName3.setText("");
        EditText etxtLastName3 = (EditText) findViewById(R.id.etxtLastName3);
        etxtLastName3.setText(drivers.getDrivers().get(1).getLastName());
        EditText etxtAccidentDriver2 = (EditText) findViewById(R.id.etxtAccidentApplicant3);
        etxtAccidentDriver2.setText(drivers.getDrivers().get(1).getAccident().getDescription());

    }

    public void onGoQuotePage(View view){

    }
}

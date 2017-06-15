package com.development.tylerwindham.liscensescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.development.tylerwindham.licenseObjects.Vehicles;

import org.w3c.dom.Text;

import mehdi.sakout.fancybuttons.FancyButton;

public class VehiclePageActivity extends AppCompatActivity {

    private Vehicles vehicles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_page);

        FancyButton continueButton = (FancyButton) findViewById(R.id.continue_button);
        TextView vehicleOne = (TextView)  findViewById(R.id.vehicle_one);
        TextView vehicleTwo = (TextView) findViewById(R.id.vehicle_two);
        vehicles = new Vehicles();

        vehicleOne.setText(vehicles.getVehicles().get(0).getVehicleName());
        vehicleTwo.setText(vehicles.getVehicles().get(1).getVehicleName());


        continueButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DriverActivity.class);
                startActivity(intent);
            }
        });


    }
}

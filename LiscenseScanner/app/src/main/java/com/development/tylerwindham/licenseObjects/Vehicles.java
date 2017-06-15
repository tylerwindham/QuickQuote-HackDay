package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Srinivas on 6/14/2017.
 */

public class Vehicles implements Parcelable {

    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicles() {
        setVehicles(vehicles);
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("2012 Acura Mdx");
        vehicle1.setMilesDriven("12000");
        vehicles.add(vehicle1);
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("2015 Lincoln MKX");
        vehicle2.setMilesDriven("10000");
        vehicles.add(vehicle2);
        this.vehicles = vehicles;
    }



    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Vehicles> CREATOR = new Parcelable.Creator<Vehicles>() {
        public Vehicles createFromParcel(Parcel in) {
            return new Vehicles();
        }

        public Vehicles[] newArray(int size) {
            return new Vehicles[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}

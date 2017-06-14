package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Srinivas on 6/14/2017.
 */

public class Vehicle implements Parcelable {

    private String vehicleName;
    private String milesDriven;

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(String milesDriven) {
        this.milesDriven = milesDriven;
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Vehicle> CREATOR = new Parcelable.Creator<Vehicle>() {
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle();
        }

        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
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

package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Dustin on 6/14/2017.
 */

public class AdditionalDrivers implements Parcelable{

    private ArrayList<Driver> drivers = new ArrayList<Driver>();
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void getDrivers(ArrayList<Driver> drivers) {
        Driver driver1 = new Driver();
        driver1.setFirstName("Han");
        driver1.setLastName("Solo");
        Accident accident1 = new Accident();
        accident1.setDescription("Friend broke the radar dish while driving through the second Death Star");
        accident1.setInjured(false);
        driver1.setAccident(accident1);
        drivers.add(driver1);
        Driver driver2 = new Driver();
        driver1.setFirstName("Indiana");
        driver1.setLastName("Jones");
        Accident accident2 = new Accident();
        accident2.setDescription("I hate snakes");
        accident2.setInjured(true);
        driver2.setAccident(accident2);
        drivers.add(driver2);
        this.drivers = drivers;
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<AdditionalDrivers> CREATOR = new Parcelable.Creator<AdditionalDrivers>() {
        public AdditionalDrivers createFromParcel(Parcel in) {
            return new AdditionalDrivers();
        }

        public AdditionalDrivers[] newArray(int size) {
            return new AdditionalDrivers[size];
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

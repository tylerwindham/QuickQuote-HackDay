package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dustin on 6/14/2017.
 */

public class Driver implements Parcelable {

    private String firstName;
    private String lastName;
    private Accident accident;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Accident getAccident() {
        return accident;
    }

    public void setAccident(Accident accident) {
        this.accident = accident;
    }

    public static final Parcelable.Creator<Driver> CREATOR = new Parcelable.Creator<Driver>() {
        public Driver createFromParcel(Parcel in) {
            return new Driver();
        }

        public Driver[] newArray(int size) {
            return new Driver[size];
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

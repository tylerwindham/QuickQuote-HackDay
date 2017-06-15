package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Dustin on 6/14/2017.
 */

public class Address implements Serializable {

    private String street;
    private String zipCode;
    private String state;
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Address> CREATOR = new Parcelable.Creator<Address>() {
        public Address createFromParcel(Parcel in) {
            return new Address();
        }

        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

    @Override
    public String toString() {
        return this.street+" "+this.city+", "+this.state+" "+this.zipCode;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//
//    }
}

package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dustin on 6/14/2017.
 */

public class Accident implements Parcelable {

    private String description;
    private boolean isInjured;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInjured() {
        return isInjured;
    }

    public void setInjured(boolean injured) {
        isInjured = injured;
    }

    public static final Parcelable.Creator<Accident> CREATOR = new Parcelable.Creator<Accident>() {
        public Accident createFromParcel(Parcel in) {
            return new Accident();
        }

        public Accident[] newArray(int size) {
            return new Accident[size];
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

package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Srinivas on 6/14/2017.
 */

public class Coverage implements Parcelable {
    private String coverageName;
    private String deductible;

    public String getCoverageName() {
        return coverageName;
    }

    public void setCoverageName(String coverageName) {
        this.coverageName = coverageName;
    }

    public String getDeductible() {
        return deductible;
    }

    public void setDeductible(String deductible) {
        this.deductible = deductible;
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Coverage> CREATOR = new Parcelable.Creator<Coverage>() {
        public Coverage createFromParcel(Parcel in) {
            return new Coverage();
        }

        public Coverage[] newArray(int size) {
            return new Coverage[size];
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

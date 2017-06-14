package com.development.tylerwindham.licenseObjects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Srinivas on 6/14/2017.
 */

public class Coverages implements Parcelable {

    public ArrayList<Coverage> getCoverages() {
        return coverages;
    }

    public void setCoverages(ArrayList<Coverage> coverages) {
        Coverage coverage1 = new Coverage();
        coverage1.setCoverageName("Basic - $100000/$30000");
        coverage1.setDeductible("$1000");
        coverages.add(coverage1);
        Coverage coverage2 = new Coverage();
        coverage2.setCoverageName("Standard - $250000/$500000");
        coverage2.setDeductible("$500");
        coverages.add(coverage2);
        Coverage coverage3 = new Coverage();
        coverage3.setCoverageName("Premium - $500000/$100000");
        coverage3.setDeductible("$250");
        coverages.add(coverage3);
        this.coverages = coverages;
    }

    private ArrayList<Coverage> coverages = new ArrayList<Coverage>();

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Coverages> CREATOR = new Parcelable.Creator<Coverages>() {
        public Coverages createFromParcel(Parcel in) {
            return new Coverages();
        }

        public Coverages[] newArray(int size) {
            return new Coverages[size];
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
